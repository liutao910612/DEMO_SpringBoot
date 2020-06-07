package com.liutao.elasticsearch.test;

import org.elasticsearch.action.admin.indices.analyze.AnalyzeRequest;
import org.elasticsearch.action.admin.indices.analyze.AnalyzeResponse;
import org.elasticsearch.action.admin.indices.analyze.DetailAnalyzeResponse;
import org.elasticsearch.client.RequestOptions;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author: LIUTAO
 * @Date: Created in 2020/06/07  16:47
 * @Modified By:
 */
public class AnalyzeApiTest extends BasicTest {


    @Test
    public void test() {
        AnalyzeRequest request = new AnalyzeRequest();
        request.text("康师傅酸菜牛肉");
        request.analyzer("standard");
        AnalyzeResponse response = null;
        try {
            response = restClient.indices().analyze(request,RequestOptions.DEFAULT );
        } catch (IOException e) {
            e.printStackTrace();
        }

        //AnalyzeToken保存了有关分析生成的单个令牌信息
        List<AnalyzeResponse.AnalyzeToken> tokens = response.getTokens();
        if(tokens == null){
            return;
        }
        for (AnalyzeResponse.AnalyzeToken token:tokens) {
            System.out.println(token.getTerm() + " start offset is " + token.getStartOffset() + "; end offset is " + token.getEndOffset());
        }

        //如果把explain设置成true,则通过detail方法返回信息
        //DetailAnalyzeResponse 包含有关分析链中不同子步骤生成的令牌的更详细信息
        DetailAnalyzeResponse detail = response.detail();
        if(detail == null){
            return;
        }
        System.out.println("detail is "+detail.toString());

    }
}
