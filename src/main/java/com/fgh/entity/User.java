package com.fgh.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;


@XmlRootElement
public class User {

	@NotNull
	private String id;
	
	@JsonProperty("name")
	@XmlElement(name="name")
	@NotNull
	@Size(min=6,max=50)
	private String name;
	
	public User(){
		
	}

	public User(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	
	
}
