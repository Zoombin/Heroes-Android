package com.juhe.heroes.entity;

import java.io.Serializable;

public class VersionEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private int version;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
