package com.fgh.util;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import com.alibaba.dubbo.common.serialize.support.SerializationOptimizer;
import com.fgh.entity.Simple;
import com.fgh.entity.User;

/**
 * 序列化
 * @author fgh
 * @since 2016年7月23日下午3:59:47
 */
public class SerializationOptimizerImpl implements SerializationOptimizer {

	@Override
	public Collection<Class> getSerializableClasses() {
		List<Class> classes = new LinkedList<Class>();
		// 这里可以把所有需要序列化的类进行添加

		classes.add(Simple.class);
		classes.add(User.class);
		return classes;
	}

}
