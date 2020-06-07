package com.liutao.elasticsearch.test;

import org.apache.lucene.search.Explanation;
import org.elasticsearch.action.explain.ExplainRequest;
import org.elasticsearch.action.explain.ExplainResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.document.DocumentField;
import org.elasticsearch.index.get.GetResult;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

/**
 * @author: LIUTAO
 * @Date: Created in 2020/06/07  10:13
 * @Modified By:
 */
public class ExplainApiTest extends BasicTest {


    @Test
    public void test() {
        ExplainRequest request = new ExplainRequest("order", "5");
        request.query(QueryBuilders.termQuery("orderName", "康师傅"));
        try {
            ExplainResponse response = restClient.explain(request, RequestOptions.DEFAULT);

            //解释文档的索引名称
            String indexName = response.getIndex();

            //解释文档的ID
            String id = response.getId();

            //查看解释文档是否存在
            boolean exists = response.isExists();
            System.out.println("index is " + indexName + "; id is " + id + "; exists is " + exists);

            //Lucene解释建模匹配，则返回true,否则返回false
            boolean match = response.isMatch();

            //查看是否存在此请求的Lucene解释
            boolean hasExplanation = response.hasExplanation();
            System.out.println("match is " + match + ";  hasExplanation is " + hasExplanation);

            //获取Lucene解释对象（如果存在）
            Explanation explanation = response.getExplanation();
            if (explanation != null) {
                System.out.println("explanation is " + explanation.toString());
            }

            //如果检索到源或存储字段，则获取getResult对象
            GetResult getResult = response.getGetResult();
            if (getResult == null) {
                return;
            }

            //getResult 内部包含两个字段，用于存储提取的源字段和存储的字段，以Map形式检索源
            Map<String, Object> source = getResult.getSource();
            if (source == null) {
                return;
            }

            for (String str : source.keySet()) {
                System.out.println("str key is " + str);
            }

            //以映射形式检索指定的存储字段
            Map<String, DocumentField> fields = getResult.getFields();
            if (fields == null) {
                return;
            }

            for (String str : fields.keySet()) {
                System.out.println("str key is " + str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
