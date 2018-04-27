package com.gxlt.myphoto.entity;
import java.util.ArrayList;
import java.util.List;

public class PhotoSort {
	private long id;
	private String name;
	private List<PhotoGraph> photos=new ArrayList<PhotoGraph>();
	private User user;
	
	public PhotoSort() {
		super();
	}
	
	public PhotoSort(String name) {
		super();
		this.name = name;
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
	public List<PhotoGraph> getPhotos() {
		return photos;
	}
	public void setPhotos(List<PhotoGraph> photos) {
		this.photos = photos;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "PhotoSort [id=" + id + ", name=" + name + "]";
	}
	
}
