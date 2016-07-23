package com.fgh.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.fgh.entity.User;
import com.fgh.service.UserService;

@Path("/userService")
@Consumes({MediaType.APPLICATION_JSON,MediaType.TEXT_XML})
@Produces({ContentType.APPLICATION_JSON_UTF_8,ContentType.TEXT_XML_UTF_8})
//这里是spring的注解
@Service("userService")
//这个是dubbo注解，同时提供dubbo本地和rest方式
@com.alibaba.dubbo.config.annotation.Service(protocol={"rest","dubbo"},interfaceClass=com.fgh.service.UserService.class,retries=0)
public class UserServiceImpl implements UserService {

	@GET
	@Path("/testGet")
	@Override
	public void testGet() {
		System.out.println("测试...get");
	}

	@GET
	@Path("/getUser")
	@Override
	public User getUser() {
		System.out.println("getUser测试...get");
		User user = new User("001","张三");
		return user;
	}

	@GET
	@Path("/get/{id:\\d+}")
	@Override
	public User getUser(@PathParam(value="id") Integer id) {
		System.out.println("getUser,id="+id);
		return new User("001","张三");
	}

	@GET
	@Path("/get/{id:\\d+}/{name:[a-zA-Z][0-9]}")
	//http://localhost:8888/provider/userService/get/3/c6
	@Override
	public User getUser(@PathParam(value="id") Integer id, @PathParam(value="name") String name) {
		System.out.println("getUser,id="+id+",name="+name);
		return new User("001","张三");
	}

	@POST
	@Path("/testPost")
	@Override
	public void testPost() {
		System.out.println("测试...post");
	}

	@Override
	public User postUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User postUser(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
