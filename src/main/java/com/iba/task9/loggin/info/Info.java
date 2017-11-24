package com.iba.task9.loggin.info;


import org.apache.log4j.Logger;

public class Info
{
    private static final Logger log = Logger.getLogger(Info.class);
    public static void writeInfo(String information)
    {
        log.info(information);
    }
}
