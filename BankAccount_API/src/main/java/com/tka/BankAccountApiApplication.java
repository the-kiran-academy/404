package com.tka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class BankAccountApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountApiApplication.class, args);
	}

}
