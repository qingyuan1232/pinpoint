package com.navercorp.pinpoint.web.config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: zhao qingyuan
 * @date: 2018-11-23 9:04
 */
public class ExecutorFactory {
    private ExecutorFactory() {
    }

    public static ExecutorService getInstance() {
        return ExecutorHolder.INSTANCE;
    }

    private static class ExecutorHolder {
        public static final ExecutorService INSTANCE = Executors.newFixedThreadPool(20);
    }
}
