package com.gxlt.myphoto.dao;

import java.util.List;
import org.mybatis.spring.annotation.MapperScan;
import com.gxlt.myphoto.entity.PhotoGraph;

@MapperScan
public interface IPhotoGraphDao {
	public List<PhotoGraph> queryBySortId(long id);
	public PhotoGraph queryById(long id);
	public List<PhotoGraph> findAllPhotos();
	public int insertPhotoByObj(PhotoGraph graph);
}
