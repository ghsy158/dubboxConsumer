package com.fgh.serial;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import com.fgh.entity.Simple;

/**
 * JDK序列化
 * 
 * @author fgh
 * @since 2016年7月23日下午2:53:57
 */
public class JavaSerial {

	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		setSerializableObject();
		System.out.println("java 序列化 writeObject time:" + (System.currentTimeMillis() - start) + "ms");
		start = System.currentTimeMillis();
		getSerializableObject();
		System.out.println("java 序列化 redObject time:" + (System.currentTimeMillis() - start) + "ms");

	}

	public static void setSerializableObject() throws Exception {
		FileOutputStream fo = new FileOutputStream("d:/jdkSerial.bin");
		ObjectOutputStream so = new ObjectOutputStream(fo);
		for (int i = 0; i < 100000; i++) {
			Map<String, Integer> map = new HashMap<String, Integer>(2);
			map.put("zhang0", i);
			map.put("zhang1", i);
			so.writeObject(new Simple("zhang" + i, (i + 1), map));
		}
		so.flush();
		so.close();
	}

	public static void getSerializableObject() {
		FileInputStream fi = null;
		try {
			fi = new FileInputStream("d:/jdkSerial.bin");
			ObjectInputStream oi = new ObjectInputStream(fi);
			Simple simple = null;
			while ((simple = (Simple) oi.readObject()) != null) {
				// System.out.println(simple.getAge()+" " + simple.getName());
			}
			fi.close();
			oi.close();
		} catch (Exception e) {
		}
	}
}
