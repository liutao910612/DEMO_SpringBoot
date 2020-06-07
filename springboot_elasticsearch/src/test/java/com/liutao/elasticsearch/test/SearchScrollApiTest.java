package com.liutao.elasticsearch.test;

import com.liutao.es.application.Application;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.*;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author: LIUTAO
 * @Date: Created in 2020/06/06  18:46
 * @Modified By:
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SearchScrollApiTest {

    @Autowired
    private RestHighLevelClient restClient;

    @Test
    public void test(){
        buildAndExecuteSearchRequest("order",2);

    }

    private void buildAndExecuteSearchRequest(String indexName,int size){
        SearchRequest searchRequest = new SearchRequest(indexName);
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.matchQuery("orderName","面"));

        //设置大小，以控制一次检索多少个结果
        sourceBuilder.size(size);
        searchRequest.source(sourceBuilder);

        //设置滚动间隔
        searchRequest.scroll(TimeValue.timeValueMinutes(1L));
        try {
            SearchResponse searchResponse = restClient.search(searchRequest,RequestOptions.DEFAULT);
            String scrollId = searchResponse.getScrollId();
            SearchHits hits = searchResponse.getHits();
            while (hits != null && hits.getHits().length != 0){

                //设置滚动标识符
                SearchScrollRequest scrollRequest = new SearchScrollRequest(scrollId);
                scrollRequest.scroll(TimeValue.timeValueSeconds(30));
                SearchResponse searchScrollResponse = restClient.scroll(scrollRequest,RequestOptions.DEFAULT);

                //读取新的滚动ID
                scrollId = searchScrollResponse.getScrollId();
                hits = searchScrollResponse.getHits();
                System.out.println("total hits is "+hits.getTotalHits().value + "; now hits is " + hits.getHits().length);
            }

            //清除滚动上下文信息
            executeClearScrollRequest(scrollId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void executeClearScrollRequest(String scrollId){
        ClearScrollRequest request = new ClearScrollRequest();

        //添加单个滚动标识
        request.addScrollId(scrollId);
        try {
            ClearScrollResponse response = restClient.clearScroll(request,RequestOptions.DEFAULT);
            boolean success = response.isSucceeded();
            int released = response.getNumFreed();
            System.out.println("success is " + success + "; released is " + released);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
