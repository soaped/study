package com.xyls.common_util.constant;

import com.google.gson.Gson;
import com.xyls.common_util.file.FileUtil;

import java.io.InputStream;


public class JsonConfig {
    public <T>  T getConfigs(Class<T> cls,String path){
        InputStream is=JsonConfig.class.getResourceAsStream(path);   
        String jsonString = FileUtil.readFileContent(is);
        return new Gson().fromJson(jsonString, cls);
    }
    
    public <T>  T getConfigsFromClassPath(Class<T> cls,String path){
        String json = ConstantConfig.getContentValue(path);
        if(json != null){
            return new Gson().fromJson(ConstantConfig.getContentValue(path), cls);
        }else{
            return null;
        }
    }
}
