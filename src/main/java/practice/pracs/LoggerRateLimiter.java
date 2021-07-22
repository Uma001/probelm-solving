package practice.pracs;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {

    Map<String,Integer> loggerState;

    public LoggerRateLimiter(){
        loggerState=new HashMap<>();

    }

    public boolean shouldPrintMessage(int timestamp,String message){
        boolean shouldPrint=false;

        if(loggerState.containsKey(message)){
            if(timestamp-loggerState.get(message)>=10){
                loggerState.put(message,timestamp);
                shouldPrint=true;
            }
        }else {
            loggerState.put(message,timestamp);
            shouldPrint=true;
        }

        return shouldPrint;

    }

    public static void main(String[] args) {
        LoggerRateLimiter logger=new LoggerRateLimiter();
        System.out.println(logger.shouldPrintMessage(1,"first log"));
        System.out.println(logger.shouldPrintMessage(9,"first log"));
        System.out.println(logger.shouldPrintMessage(11,"Hi log"));
        System.out.println(logger.shouldPrintMessage(11,"first log"));
    }
}
