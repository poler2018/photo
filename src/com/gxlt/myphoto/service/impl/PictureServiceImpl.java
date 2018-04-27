package com.gxlt.myphoto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxlt.myphoto.dao.IPictureDao;
import com.gxlt.myphoto.entity.Picture;
import com.gxlt.myphoto.service.IPictureService;
@Service("pictureService")
public class PictureServiceImpl implements IPictureService{
	@Autowired
	private IPictureDao pictureDao;

	@Override
	public int addPhoto(Picture picture) {
		return pictureDao.insertPhoto(picture);
	}

	@Override
	public List<Picture> findAllPhoto(long id) {
		return pictureDao.queryAllPhoto(id);
	}

	/**
	 * 根据用户查找对应用户的ID
	 */
	@Override
	public List<Picture> findPhotoByAlbum(long userId, String AlbumName) {
		return pictureDao.queryPhotoByAlbum(userId, AlbumName);
	}
}
