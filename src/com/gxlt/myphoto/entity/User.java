package com.gxlt.myphoto.entity;

import java.util.ArrayList;
import java.util.List;

public class User {
	private long id;
	private String name;
	private String password;
	private List<PhotoSort> sort=new ArrayList<PhotoSort>();
	private List<PhotoAlbum> album=new ArrayList<PhotoAlbum>();
	public User() {
		super();
	}
	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<PhotoSort> getSort() {
		return sort;
	}
	public void setSort(List<PhotoSort> sort) {
		this.sort = sort;
	}
	
	public List<PhotoAlbum> getAlbum() {
		return album;
	}
	public void setAlbum(List<PhotoAlbum> album) {
		this.album = album;
	}
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + "]";
	}


}
