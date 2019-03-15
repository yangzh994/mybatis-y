package com.mi.tu.cai.niao.io;

import java.io.InputStream;

/**
 * @author yangzh
 */
public class ClassLoaderWrapper {

    ClassLoader systemClassLoader;

    public ClassLoaderWrapper(){
        try{
            systemClassLoader = ClassLoader.getSystemClassLoader();
        }catch (SecurityException e){

        }
    }

    public InputStream getResourceAsStream(String resource, ClassLoader loader) {

        return getResourceAsStream(resource,getClassLoaders(loader));
    }

    public InputStream getResourceAsStream(String resource, ClassLoader[] loaders) {
        for (ClassLoader loader:loaders) {
            if(loader != null){
                InputStream resourceAsStream = loader.getResourceAsStream(resource);
                if(resourceAsStream == null){
                    resourceAsStream = loader.getResourceAsStream("/" + resource);
                }
                if(resourceAsStream != null){
                    return resourceAsStream;
                }
            }
        }
        return null;
    }


    private ClassLoader[] getClassLoaders(ClassLoader loader){
        return new ClassLoader[]{
            loader,Thread.currentThread().getContextClassLoader(),getClass().getClassLoader(),systemClassLoader
        };
    }
}
