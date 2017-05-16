package com.liutao.userTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * 打包测试
 * Created by liutao on 2017/3/18.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({UserTest.class,ParameterTest.class})
public class SuitTest {
    //里面不需要编写任何代码
}
