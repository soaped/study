package com.xyls.common_util.serial;


import com.xyls.common_util.constant.PathUtil;

import java.io.File;
import java.io.Serializable;


public class SerialObject implements Serializable {

    private static final long serialVersionUID = 9152967839109445090L;

    
    protected String relativePath;
    public SerialObject setRelativePath(String relativePath) {
        this.relativePath = relativePath;
        return this;
    }

    public static <T extends SerialObject> T getSerialObject(String relativePath, Class<T> cls) throws InstantiationException, IllegalAccessException{
        if(SerialUtil.FileSystemToObject(PathUtil.getJarOrTargetPath(SerialObject.class) + relativePath) == null){
            cls.newInstance().setRelativePath(relativePath).save();
        }
        @SuppressWarnings("unchecked")
        T t =  (T)SerialUtil.FileSystemToObject(PathUtil.getJarOrTargetPath(SerialObject.class) + relativePath);
        t.relativePath = relativePath;
        return t;
    }
    
    public void save(){
        SerialUtil.ObjectToFileSystem(this, PathUtil.getJarOrTargetPath(SerialObject.class) + relativePath);
    }
    public void del(){
        new File(PathUtil.getJarOrTargetPath(SerialObject.class) + relativePath).delete();
    }
}
