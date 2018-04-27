package com.gxlt.myphoto.service;

import java.util.List;

import com.gxlt.myphoto.entity.Picture;

public interface IPictureService {
	public int addPhoto(Picture picture);
	public List<Picture> findAllPhoto(long id);
	/**
	 * ���Ҷ�Ӧ�û���ID�����
	 * @param userId
	 * @param AlbumName
	 * @return
	 */
	public List<Picture> findPhotoByAlbum(long userId,String AlbumName);
	
}
