package com.gxlt.myphoto.service;

import java.util.List;

import com.gxlt.myphoto.entity.PhotoSort;
public interface IPhotoSortService {
	public List<PhotoSort> findById(long id);

	public List<PhotoSort> findAllByUid(long uid);
	public int addSort(PhotoSort sort);
	/**
	 * ͨ����������û�id���
	 * @param name
	 * @param uid
	 * @return
	 */
	public int addSortByNameAndUid(PhotoSort sort);

	public List<PhotoSort> findAll();
}
