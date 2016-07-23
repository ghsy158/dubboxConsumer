package com.fgh.test;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fgh.entity.User;
import com.fgh.service.UserService;

public class Consumer {

	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-consumer.xml");
	
		context.start();
		System.out.println("服务已启动...");
		
		UserService userService = (UserService) context.getBean("userService");
		User user = userService.getUser();
		System.out.println(user);
		System.in.read();//为了保证服务一直开着，利用输入流的阻塞来模拟
	}
}
