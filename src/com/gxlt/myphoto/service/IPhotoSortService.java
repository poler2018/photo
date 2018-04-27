package com.gxlt.myphoto.service;

import java.util.List;

import com.gxlt.myphoto.entity.PhotoSort;
public interface IPhotoSortService {
	public List<PhotoSort> findById(long id);

	public List<PhotoSort> findAllByUid(long uid);
	public int addSort(PhotoSort sort);
	/**
	 * 通过相册名和用户id添加
	 * @param name
	 * @param uid
	 * @return
	 */
	public int addSortByNameAndUid(PhotoSort sort);

	public List<PhotoSort> findAll();
}
