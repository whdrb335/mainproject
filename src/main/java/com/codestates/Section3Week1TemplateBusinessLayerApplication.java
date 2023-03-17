package com.codestates;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Entity;


// 계속 Repository bean 등록안되어있는 오류가 떠서 이것을 설정해주었다
@SpringBootApplication
public class Section3Week1TemplateBusinessLayerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Section3Week1TemplateBusinessLayerApplication.class, args);
	}

}
