package com.sf.multimodal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

//@PropertySource("classpath:dubbo/dubbo.properties")
@ImportResource(locations = {"classpath:user-dubbo.xml"})
@SpringBootApplication
public class MultimodalUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultimodalUserApplication.class, args);
    }

}

