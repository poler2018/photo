package com.gxlt.myphoto.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxlt.myphoto.dao.IPhotoSortDao;
import com.gxlt.myphoto.entity.PhotoSort;
import com.gxlt.myphoto.service.IPhotoSortService;
@Service("photoSortService")
public class PhotoSortServiceImpl implements IPhotoSortService {
	@Autowired
	private IPhotoSortDao photoSortDao;
	@Override
	public int addSort(PhotoSort sort) {
		int rows = photoSortDao.insert(sort);
		return rows;
	}

	@Override
	public List<PhotoSort> findAll() {
		return null;
	}
	/**
	 * Í¨¹ýid²éÕÒ
	 */
	@Override
	public List<PhotoSort> findById(long id) {
		PhotoSort sort = photoSortDao.queryById(id);
		System.out.println("sort:"+sort);
		List<PhotoSort> list=new ArrayList<PhotoSort>();
		list.add(sort);
		return list;
	}

	@Override
	public int addSortByNameAndUid(PhotoSort sort) {
		int rows = photoSortDao.insertSortByNameAndUid(sort);
		return rows;
	}

	@Override
	public List<PhotoSort> findAllByUid(long uid) {
		return photoSortDao.findAllByUid(uid);
	}

}
