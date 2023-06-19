package com.lcwd.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchDataAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication(exclude = ElasticsearchDataAutoConfiguration.class)
@EnableEurekaClient
@EnableFeignClients
@EnableAspectJAutoProxy
public class UserServiceApplication {

	public static void main(String[] args) {
			
		SpringApplication.run(UserServiceApplication.class, args);
	}       
}
