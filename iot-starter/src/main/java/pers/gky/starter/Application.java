package pers.gky.starter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Administrator
 */
@Slf4j
@SpringBootApplication(scanBasePackages = "pers.gky")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
