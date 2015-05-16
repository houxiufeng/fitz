package com.xiaoma.fitz.utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class LogRecord {
    private static final Logger info = LoggerFactory.getLogger("InfoLogger");
    private static final Logger error = LoggerFactory.getLogger("ErrorLogger");
    public LogRecord(){}
    
    /**
     * 一般情况记录到/logs/infoLog.txt
     */
    public static void info(String infomation){
        info.info(infomation);
    }
    
    /**
     * 错误信息记录到/logs/errorLog.txt
     */
    public static void error(String infomation){
        error.error(infomation);
    }
}


