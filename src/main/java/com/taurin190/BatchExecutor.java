package com.taurin190;

import com.taurin190.controller.BatchController;
import com.taurin190.controller.AuthorController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;


@SpringBootApplication
public class BatchExecutor implements CommandLineRunner {
    @Autowired
    private ApplicationContext context;

    @Autowired
    private Environment env;

    @Qualifier("com.taurin190.controller.BlogController")
    @Autowired
    private BatchController batchController;

    private static final Logger log = LoggerFactory.getLogger(BatchExecutor.class);

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(BatchExecutor.class);
        ApplicationContext context = application.run();
        SpringApplication.exit(context);
    }
    @Override
    public void run(String... args) throws Exception {
//        Class<?> cls = Class.forName("AuthorController");
//        BatchController batchController = (BatchController) cls.newInstance();
//        BatchController batchController = (BatchController) new AuthorController();
        batchController.exec();
    }


}
