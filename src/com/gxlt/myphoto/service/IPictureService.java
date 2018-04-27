package com.gxlt.myphoto.service;

import java.util.List;

import com.gxlt.myphoto.entity.Picture;

public interface IPictureService {
	public int addPhoto(Picture picture);
	public List<Picture> findAllPhoto(long id);
	/**
	 * 查找对应用户的ID和相册
	 * @param userId
	 * @param AlbumName
	 * @return
	 */
	public List<Picture> findPhotoByAlbum(long userId,String AlbumName);
	
}
