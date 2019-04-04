package com.capgemini.managingCart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.capgemini.managingCart")
@EntityScan("com.capgemini.managingCart.beans")
public class ManagingCartApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagingCartApplication.class, args);
	}

}
