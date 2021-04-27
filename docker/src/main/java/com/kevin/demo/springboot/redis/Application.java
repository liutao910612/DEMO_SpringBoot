package com.kevin.demo.springboot.springboot.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author LIUTAO
 * @version 2020/10/09
 * @see
 * @since
 */
@SpringBootApplication
@ComponentScan(basePackages={"com.kevin"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
