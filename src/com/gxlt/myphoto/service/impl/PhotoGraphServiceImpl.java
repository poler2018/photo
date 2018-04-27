package com.gxlt.myphoto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gxlt.myphoto.dao.IPhotoGraphDao;
import com.gxlt.myphoto.entity.PhotoGraph;
import com.gxlt.myphoto.service.IPhotoGraphService;

@Service("photoGraphService")
public class PhotoGraphServiceImpl implements IPhotoGraphService {
	@Autowired
	private IPhotoGraphDao photoDao;
	@Override
	public int addPhoto(PhotoGraph graph) {
		int rows = photoDao.insertPhotoByObj(graph);
		return rows;
	}

}
