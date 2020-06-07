package com.liutao.elasticsearch.test;

import com.liutao.es.application.Application;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.fieldcaps.FieldCapabilities;
import org.elasticsearch.action.fieldcaps.FieldCapabilitiesRequest;
import org.elasticsearch.action.fieldcaps.FieldCapabilitiesResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.IndicesOptions;
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
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author: LIUTAO
 * @Date: Created in 2020/06/07  09:29
 * @Modified By:
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class FieldCapabilitiesApiTest {

    @Autowired
    private RestHighLevelClient restClient;

    @Test
    public void test(){
        FieldCapabilitiesRequest request = new FieldCapabilitiesRequest().fields("userName","orderName").indices("order","user");
        request.indicesOptions(IndicesOptions.lenientExpandOpen());
        try {
            FieldCapabilitiesResponse response = restClient.fieldCaps(request,RequestOptions.DEFAULT);

            //处理返回结果，获取字段中可能返回的类型映射
            Map<String,FieldCapabilities> fieldResponse = response.getField("userName");
            Set<String> set = fieldResponse.keySet();

            //获取文本字段类型下的数据
            FieldCapabilities textCapabilities = fieldResponse.get("text");

            //数据能否被聚合
            boolean isAggregatable = textCapabilities.isAggregatable();
            System.out.println("isAggregatable is "+ isAggregatable);

            //数据能否搜索到
            boolean isSearchable = textCapabilities.isSearchable();
            System.out.println("isSearchable is " + isSearchable);

            //获取特定字段类型下的索引
            String[] indicesArray = textCapabilities.indices();
            if(indicesArray != null){
                System.out.println("indicesArray is " + indicesArray.length);
            }

            //field字段不能被搜索到索引集合
            String[] noneSerchableIndices = textCapabilities.nonSearchableIndices();
            if(noneSerchableIndices != null){
                System.out.println("noneSerchableIndices is " + noneSerchableIndices.length);
            }

            //field字段不能被聚合到索引集合
            String[] nonAggregatableIndices = textCapabilities.nonAggregatableIndices();
            if(nonAggregatableIndices != null){
                System.out.println("nonAggregatableIndices is " + nonAggregatableIndices.length);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
