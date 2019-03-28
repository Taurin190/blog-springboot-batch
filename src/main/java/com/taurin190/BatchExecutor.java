package com.taurin190;

import com.taurin190.controller.BatchController;
import com.taurin190.controller.AuthorController;
import com.taurin190.controller.BlogController;
import com.taurin190.controller.WorkController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication(scanBasePackages = {"com.taurin190"})
public class BatchExecutor implements CommandLineRunner{

    private static final Logger log = LoggerFactory.getLogger(BatchExecutor.class);

    @Autowired
    AuthorController authorController;

    @Autowired
    BlogController blogController;

    @Autowired
    WorkController workController;

    BatchController batchController;

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(BatchExecutor.class);
        ApplicationContext context = application.run(args);
        SpringApplication.exit(context);
    }

    @Override
    public void run(String... args) throws Exception {
        switch (args[0]) {
            case "author":
                batchController = authorController;
                break;
            case "blog":
                batchController = blogController;
                break;
            default:
                batchController = blogController;
                break;
        }
        batchController.exec();
    }
}
