package com.taurin190;

import com.taurin190.controller.BatchController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableAutoConfiguration
@EnableBatchProcessing
@EnableConfigurationProperties
public class BatchExecutor implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(BatchExecutor.class);
    @Override
    public void run(String... args) throws Exception {
        Class<?> cls = Class.forName(args[1] + "Controller");
        BatchController batchController = (BatchController) cls.newInstance();
        batchController.exec();
    }
}
