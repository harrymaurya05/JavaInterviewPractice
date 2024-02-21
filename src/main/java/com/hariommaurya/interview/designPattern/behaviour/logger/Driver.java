package com.hariommaurya.interview.designPattern.behaviour.logger;

public class Driver {
    public static void main(String[] args) {
        LogProcessor logProcessor = new InfoLogProcessor(new DebugLogProcessor(null));
        logProcessor.log(LogProcessor.INFO,"Info log msg!");
        logProcessor.log(LogProcessor.DEBUG,"Debug log msg!");
        logProcessor.log(LogProcessor.ERROR,"Error log msg!");
    }
}
