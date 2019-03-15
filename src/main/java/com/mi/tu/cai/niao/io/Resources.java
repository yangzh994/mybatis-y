package com.mi.tu.cai.niao.io;

import java.io.InputStream;

/**
 * @author yangzh
 */
public class Resources {

    static ClassLoaderWrapper classLoaderWrapper = new ClassLoaderWrapper();

    private Resources(){}

    public static InputStream getResourceAsStream(String resource){
        return getResourceAsStream(resource,null);
    }

    public static InputStream getResourceAsStream(String resource,ClassLoader loader){
        return classLoaderWrapper.getResourceAsStream(resource,loader);
    }

}
