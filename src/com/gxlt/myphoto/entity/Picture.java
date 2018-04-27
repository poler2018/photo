package com.gxlt.myphoto.entity;
public class Picture {
	private long id;
	private long albumId;
	private String photoName;
	private String upTime;
	private PhotoAlbum photoAlbum;
	
	public Picture() {
		super();
	}
	
	public Picture(long id, long albumId, String photoName, String upTime) {
		super();
		this.id = id;
		this.albumId = albumId;
		this.photoName = photoName;
		this.upTime = upTime;
	}

	public Picture(long albumId, String photoName, String upTime) {
		super();
		this.albumId = albumId;
		this.photoName = photoName;
		this.upTime = upTime;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getAlbumId() {
		return albumId;
	}
	public void setAlbumId(long albumId) {
		this.albumId = albumId;
	}
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	public String getUpTime() {
		return upTime;
	}
	public void setUpTime(String upTime) {
		this.upTime = upTime;
	}
	
	public PhotoAlbum getPhotoAlbum() {
		return photoAlbum;
	}

	public void setPhotoAlbum(PhotoAlbum photoAlbum) {
		this.photoAlbum = photoAlbum;
	}

	@Override
	public String toString() {
		return "Picture [id=" + id + ", albumId=" + albumId + ", photoName=" + photoName + ", upTime=" + upTime + "]";
	}
	
}
