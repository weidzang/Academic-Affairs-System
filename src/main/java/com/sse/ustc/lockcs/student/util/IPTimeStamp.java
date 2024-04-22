package com.sse.ustc.lockcs.student.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class IPTimeStamp {

    private SimpleDateFormat simpleDateFormat;
    private String filename;

    public IPTimeStamp(String filename){
        this.filename = filename;
    }
    /**
     *
     * @return 返回文件名
     */
    public String getIPTimeStamp(){
        StringBuffer sBuffer = new StringBuffer();
        if(filename!=null){
            String[] strings = filename.split("\\.");
            if(strings.length>0){
                sBuffer.append(strings[0]+"_");
            }
        }
        sBuffer.append(this.getTimeStamp());
        Random random = new Random();
        for(int i=0;i<3;i++){
            sBuffer.append(random.nextInt(10));
        }
        return sBuffer.toString();
    }
    /**
     * ip地址不足三位数的在其前面用0补齐
     * @param str 表示ip某一段的字符串
     * @param len 补齐后的长度
     * @return 返回补齐后的字符串
     */
    public String addZero(String str,int len){
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        while(sb.length()<len){
            sb.insert(0, "0");
        }
        return sb.toString();
    }
    public String getTimeStamp(){
        Date date = new Date();
        this.simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return this.simpleDateFormat.format(date);
    }
}
