package com.liutao.userTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

/**
 * 参数测试
 * Created by liutao on 2017/3/18.
 */
@RunWith(Parameterized.class)
public class ParameterTest {

    private String name;
    private boolean result;

    /**
     * 该构造方法的参数与下面@Parameters注解的方法中的Object数组中值的顺序对应
     * @param name
     * @param result
     */
    public ParameterTest(String name, boolean result) {
        super();
        this.name = name;
        this.result = result;
    }

    @Test
    public void test() {
        assertTrue(name.contains("da") == result);
    }

    /**
     * 该方法返回Collection
     *
     * @return
     * @author SHANHY
     * @create  2016年2月26日
     */
    @Parameterized.Parameters
    public static Collection<?> data(){
        // Object 数组中值的顺序注意要和上面的构造方法ParameterTest的参数对应
        return Arrays.asList(new Object[][]{
                {"小明2", true},
                {"坏", false},
                {"莉莉", false},
        });
    }
}
