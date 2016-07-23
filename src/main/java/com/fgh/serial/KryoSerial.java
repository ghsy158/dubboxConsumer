package com.fgh.serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.objenesis.strategy.StdInstantiatorStrategy;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.fgh.entity.Simple;

/**
 * Kryo序列化
 * @author fgh
 * @since 2016年7月23日下午3:12:06
 */
public class KryoSerial {

	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		setSerializableObject();
		System.out.println("kryo 序列化 writeObject time:" + (System.currentTimeMillis() - start) + "ms");
		start = System.currentTimeMillis();
		getSerializableObject();
		System.out.println("kryo 序列化 redObject time:" + (System.currentTimeMillis() - start) + "ms");

	}

	public static void setSerializableObject() throws Exception {
		Kryo kryo = new Kryo();
		kryo.setReferences(false);
		kryo.setRegistrationRequired(false);
		kryo.setInstantiatorStrategy(new StdInstantiatorStrategy());
		kryo.register(Simple.class);
		Output output = new Output(new FileOutputStream("d:/kryoSerial.bin"));
//		FileOutputStream fo = new FileOutputStream("d:/jdkSerial.bin");
//		ObjectOutputStream so = new ObjectOutputStream(fo);
		for (int i = 0; i < 100000; i++) {
			Map<String, Integer> map = new HashMap<String, Integer>(2);
			map.put("zhang0", i);
			map.put("zhang1", i);
			kryo.writeObject(output,new Simple("zhang" + i, (i + 1), map));
		}
		output.flush();
		output.close();
	}

	public static void getSerializableObject() {
		Kryo kryo = new Kryo();
		kryo.setReferences(false);
		kryo.setRegistrationRequired(false);
		kryo.setInstantiatorStrategy(new StdInstantiatorStrategy());
		
//		FileInputStream fi = null;
		try {
//			fi = new FileInputStream("d:/jdkSerial.bin");
			Input input = new Input(new FileInputStream("d:/kryoSerial.bin"));
//			ObjectInputStream oi = new ObjectInputStream(fi);
			Simple simple = null;
			while ((simple = (Simple) kryo.readObject(input, Simple.class)) != null) {
				// System.out.println(simple.getAge()+" " + simple.getName());
			}
			input.close();
		} catch (Exception e) {
		}
	}
}
