package com.gxlt.myphoto.dao;

import java.util.List;
import org.mybatis.spring.annotation.MapperScan;

import com.gxlt.myphoto.entity.PhotoSort;

@MapperScan
public interface IPhotoSortDao {
	public PhotoSort queryById(long id);

	public int insert(PhotoSort sort);

	public List<PhotoSort> findAllSort();
	
	public List<PhotoSort> findAllByUid(long uid);
	/**
	 * ����Ӧ���û���������
	 * @param name
	 * @param uid
	 * @return
	 */
	public int insertSortByNameAndUid(PhotoSort sort);
}
