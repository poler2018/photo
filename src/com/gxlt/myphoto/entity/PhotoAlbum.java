package com.gxlt.myphoto.entity;

import java.util.ArrayList;
import java.util.List;
public class PhotoAlbum {
	private long id;
	private long userId;//用户账号id
	private String albumName;//相册名称
	private List<Picture> picture=new ArrayList<Picture>();
	private User user;
	
	public PhotoAlbum() {
		super();
	}
	
	public PhotoAlbum(long id, long userId, String albumName) {
		super();
		this.id = id;
		this.userId = userId;
		this.albumName = albumName;
	}



	public PhotoAlbum(long userId, String albumName) {
		super();
		this.userId = userId;
		this.albumName = albumName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public List<Picture> getPicture() {
		return picture;
	}

	public void setPicture(List<Picture> picture) {
		this.picture = picture;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "PhotoAlbum [id=" + id + ", userId=" + userId + ", albumName=" + albumName + ", picture=" + picture
				+ ", user=" + user + "]";
	}

	
}
