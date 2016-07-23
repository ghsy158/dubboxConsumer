package com.fgh.test;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Provider {

	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-provider.xml");
	
		context.start();
		System.out.println("服务已启动...");
		System.in.read();//为了保证服务一直开着，利用输入流的阻塞来模拟
	}
}
