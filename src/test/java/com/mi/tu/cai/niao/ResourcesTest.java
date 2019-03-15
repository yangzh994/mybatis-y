package com.mi.tu.cai.niao;

import com.mi.tu.cai.niao.io.Resources;
import org.junit.Test;

import java.io.InputStream;


public class ResourcesTest {
    @Test
    public void test1(){
        String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
    }
}
