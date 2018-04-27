package com.gxlt.myphoto.entity;

public class PhotoGraph {
	private long id;
	private String name;
	private PhotoSort photoSort;
	private String uptime;
	public PhotoGraph() {
		super();
	}
	public PhotoGraph(String name) {
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
	public PhotoSort getPhotoSort() {
		return photoSort;
	}
	public void setPhotoSort(PhotoSort photoSort) {
		this.photoSort = photoSort;
	}
	
	public String getUptime() {
		return uptime;
	}
	public void setUptime(String uptime) {
		this.uptime = uptime;
	}
	@Override
	public String toString() {
		return "PhotoGraph [id=" + id + ", name=" + name + "]";
	}

}
