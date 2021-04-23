package com.liutao.elasticsearch.test;

import com.liutao.es.application.Application;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.MatchQueryBuilder;
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
public class SearchApiTest {

    @Autowired
    private RestHighLevelClient restClient;

    @Test
    public void test(){
        SearchRequest searchRequest = buildSearchRequest();
        try {
            SearchResponse searchResponse = restClient.search(searchRequest, RequestOptions.DEFAULT);
            System.out.println(searchResponse.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private SearchRequest buildSearchRequest(){
        SearchRequest searchRequest = new SearchRequest("order");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder("orderName","康师傅");

        //fuzzy query
        matchQueryBuilder.fuzziness(Fuzziness.AUTO);

        searchSourceBuilder.query(matchQueryBuilder);
        searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

        //sort
        searchSourceBuilder.sort(new FieldSortBuilder("num").order(SortOrder.ASC));

        //include and exclud
        String[] includeFields = new String[]{"orderName","num","orderType"};
        String[] excludeFields = new String[]{"id"};
        searchSourceBuilder.fetchSource(includeFields,excludeFields);

        //high light
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        HighlightBuilder.Field highlightOrderType = new HighlightBuilder.Field("orderType");
        highlightOrderType.highlighterType("unified");
        highlightBuilder.field(highlightOrderType);
        searchSourceBuilder.highlighter(highlightBuilder);

        searchRequest.source(searchSourceBuilder);

        return searchRequest;
    }

    private SearchRequest aggregation(){
        SearchRequest searchRequest = new SearchRequest();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        TermsAggregationBuilder aggregation = AggregationBuilders.terms("by_type").field("orderType");
        aggregation.subAggregation(AggregationBuilders.avg("average_num")).field("num");
        searchSourceBuilder.aggregation(aggregation);

        return searchRequest;
    }
}
