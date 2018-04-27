package com.gxlt.myphoto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxlt.myphoto.dao.IPhotoAlbumDao;
import com.gxlt.myphoto.entity.PhotoAlbum;
import com.gxlt.myphoto.service.IPhotoAlbumService;
@Service("photoAlbumService")
public class PhotoAlbumService implements IPhotoAlbumService{
	@Autowired
	private IPhotoAlbumDao photoAlbumDao;

	/**
	 * ÃÌº”œ‡≤·
	 */
	@Override
	public int insertAlbumName(PhotoAlbum photoalbum) {
		return photoAlbumDao.insertByuserIdAndName(photoalbum);
	}

	@Override
	public List<PhotoAlbum> findAllById(int id) {
		return photoAlbumDao.queryAllById(id);
	}
}
