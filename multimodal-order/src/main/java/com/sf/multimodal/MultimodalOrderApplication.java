package com.sf.multimodal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource(locations = {"classpath:order-dubbo.xml"})
@SpringBootApplication
public class MultimodalOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultimodalOrderApplication.class, args);
	}

}

