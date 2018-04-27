package com.gxlt.myphoto.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.gxlt.myphoto.entity.Picture;
@MapperScan
public interface IPictureDao {
	public Picture queryById(int id);
	public int insertPhoto(Picture picture);
	public List<Picture> queryAllPhoto(long id);
	//
	public List<Picture> queryPhotoByAlbum(long userId, String AlbumName);
}
