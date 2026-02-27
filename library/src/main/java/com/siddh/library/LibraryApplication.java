package com.siddh.library;

import com.siddh.library.controller.TransactionalController;
import com.siddh.library.service.TransactionDemo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {

        SpringApplication.run(LibraryApplication.class, args);
	}

}
