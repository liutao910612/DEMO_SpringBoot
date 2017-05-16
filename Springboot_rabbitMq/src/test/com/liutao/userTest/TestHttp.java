package com.liutao.userTest;

import com.liutao.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * Created by liutao on 2017/3/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest("server.port:0")// 使用0表示端口号随机，也可以具体指定如8888这样的固定端口
public class TestHttp {
    private String dateReg;
    private RestTemplate template = new TestRestTemplate();
    @Value("${local.server.port}")// 注入端口号
    private int port;

    @Test
    public void test3(){
//        String url = "http://localhost:"+port+"/myspringboot/hello/info";
//        MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
//        map.add("name", "Tom");
//        map.add("name1", "Lily");
//        String result = template.getForObject(url,);
//        System.out.println(result);
//        assertNotNull(result);
//        assertThat(result, Matchers.containsString("Tom"));
    }
}
