package com.juhe.heroes.activity;

import java.io.Serializable;

public class ImageEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String imagepath;

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
