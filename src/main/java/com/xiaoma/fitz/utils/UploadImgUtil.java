package com.xiaoma.fitz.utils;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UploadImgUtil {
    private static final Logger LOG = LoggerFactory.getLogger(UploadImgUtil.class);
    private static final String BUCKET_NAME = "unifiedxmpg";
    private static final String OPERATOR_NAME = "unifiedxmpg";
    private static final String OPERATOR_PWD = "unifiedxmpg";
    private static final String URL = "http://" + BUCKET_NAME + ".b0.upaiyun.com";
    private static final String DIR_ROOT = "/img/";
    
    public static String uploadImg(byte[] image, String imageName) throws IOException{
        UpYun upyun = new UpYun(BUCKET_NAME, OPERATOR_NAME, OPERATOR_PWD);
        upyun.setDebug(false);
        // 要传到upyun后的文件路径
        String filePath = DIR_ROOT  + imageName;
        boolean result = upyun.writeFile(filePath, image, true);
        String url = null;
        if(result){
            LOG.info("upload image successful");
            url = URL + filePath;
        }
        return url;
    }
}
