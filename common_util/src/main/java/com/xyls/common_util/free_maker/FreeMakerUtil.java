package com.xyls.common_util.free_maker;

import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ipaynow1130 on 2017/4/25.
 */
public class FreeMakerUtil {

    private static Map<String , Template> templateHashMap = new HashMap<String,Template>();


    /**
     * 使用freeMaker渲染数据模板
     * @param templateDefine，模板，针对第二个对象数组,第一个元素使用_0表示,第二个元素使用_1表示,依次类推
     * @param objects 数据
     * @return
     * @throws IOException
     */
    public static String render(String templateDefine,Object[] objects) throws IOException {
        if(templateHashMap.get(templateDefine) == null){
            synchronized (FreeMakerUtil.class){
                if(templateHashMap.get(templateDefine) == null){
                    templateHashMap.put(templateDefine,new Template(null,templateDefine,null));
                }
            }
        }
        Map<String, Object> map = new HashMap<>();
        for(int i = 0 ;i < objects.length ;i ++){
            map.put("_" + String.valueOf(i),objects[i]);
        }
        Writer out = new StringWriter();
        try {
            templateHashMap.get(templateDefine).process(map,out);
            return out.toString();
        } catch (TemplateException e) {
            e.printStackTrace();
            return null;
        }finally {
            out.flush();
            out.close();
        }
    }



    public static void main(String [] args){
        String templateDefine = "${_0.id}_${_0.mchId!}_${_0.withMchInfo!}_${_1.id}_${_1.mchId!}";
        GetReq getReq = new GetReq();
        getReq.setId("id");
        getReq.setMchId("mchid");
        getReq.setWithMchInfo(0);

        GetReq getReq1 = new GetReq();
        getReq1.setId("id1");
        getReq1.setMchId("mchid1");
        getReq1.setWithMchInfo(1);
        try {
            String s = FreeMakerUtil.render(templateDefine,new Object[]{getReq,getReq1});
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static class GetReq{
        private String id;
        private String mchId;
        private Integer withMchInfo;

        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
        public String getMchId() {
            return mchId;
        }
        public void setMchId(String mchId) {
            this.mchId = mchId;
        }
        public Integer getWithMchInfo() {
            return withMchInfo;
        }
        public void setWithMchInfo(Integer withMchInfo) {
            this.withMchInfo = withMchInfo;
        }
    }
}
