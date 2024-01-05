package aaagt.hibernate.app.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "aaagt.hibernate")
@EntityScan("aaagt.hibernate")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
