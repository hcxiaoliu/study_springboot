package com.xiaoliu.until;

import com.xiaoliu.exception.AppException;
import org.apache.tomcat.util.codec.binary.Base64;

import java.io.FileOutputStream;
import java.io.OutputStream;



public class Base64MyUtil {
	
    /**
                * 文件上传操作base64 上传
     * @param imgStr 文件的base64转码
     * @param realpath   需要写入的路径
     */
    //base64字符串转化成图片  
    public static void GenerateImage(String imgStr,String realpath)  
    {   //对字节数组字符串进行Base64解码并生成图片  
        if (imgStr == null) //图像数据为空  
            throw new AppException("图片需大于0KB 而且 小于5M");
        try   
        {  
            byte[] b = 
            		Base64.decodeBase64(imgStr);
            for(int i=0;i<b.length;++i)  
            {  
                if(b[i]<0)  
                { 
                    b[i]+=256;  
                }  
            }  
            //生成图片  
            OutputStream out = new FileOutputStream(realpath);      
            out.write(b);  
            out.flush();  
            out.close();  
 
        }   
        catch (Exception e)   
        {  
        	throw new AppException("上传异常");   
        }  
    }  
}
