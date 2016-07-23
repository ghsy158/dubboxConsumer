package com.fgh.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fgh.entity.Simple;
import com.fgh.service.SimpleService;

@Service("simpleService")
@com.alibaba.dubbo.config.annotation.Service(interfaceClass=com.fgh.service.SimpleService.class ,protocol = { "dubbo" })
public class SimpleServiceImpl implements SimpleService {

	@Override
	public String sayHello(String name) {
		return "hello " + name;
	}

	@Override
	public Simple getSimple() {
		Map<String, Integer> map = new HashMap<String, Integer>(2);
		map.put("1", 1);
		map.put("2", 2);
		return new Simple("zhangsan", 25, map);
	}

}
