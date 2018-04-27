package com.gxlt.myphoto.service;

import java.util.List;

import com.gxlt.myphoto.entity.PhotoAlbum;

public interface IPhotoAlbumService {
	public int insertAlbumName(PhotoAlbum photoalbum);
	public List<PhotoAlbum> findAllById(int id);
}
