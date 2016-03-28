package com.juhe.heroes.entity;

import java.io.Serializable;

public class HeroEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private String imagepath;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

}
