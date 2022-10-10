package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        int age = 24;
        boolean accept = true;
        char symb = 'A';
        byte b = 127;
        short s = 0;
        long l = 1000005;
        float f = 2.75134f;
        double dd = 235.6;
        LOG.debug("User info age : {}", age);
        LOG.debug("accepting info : {}", accept);
        LOG.debug("symbol info : {}", symb);
        LOG.debug("byte info : {}", b);
        LOG.debug("short info : {}", s);
        LOG.debug("long info : {}", l);
        LOG.debug("float info : {}", f);
        LOG.debug("double info : {}", dd);
    }
}