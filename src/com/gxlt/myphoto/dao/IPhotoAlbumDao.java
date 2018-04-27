package com.gxlt.myphoto.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.gxlt.myphoto.entity.PhotoAlbum;
@MapperScan
public interface IPhotoAlbumDao {
	public PhotoAlbum queryById(int id);
	public int insertByuserIdAndName(PhotoAlbum photoalbum);
	public List<PhotoAlbum> queryAllById(int id);
}
