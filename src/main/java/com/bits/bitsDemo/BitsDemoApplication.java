package com.bits.bitsDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.bits.bitsDemo"})

public class BitsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BitsDemoApplication.class, args);
	}

}

