package com.gxlt.myphoto.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import com.gxlt.myphoto.entity.User;

@MapperScan
public interface IUserDao {
	/**
	 * ͨ��id��ѯ������User����
	 * 
	 * @param id
	 * @return
	 */
	public User queryById(int id);

	/**
	 * ͨ���û��������ѯ
	 * 
	 * @return
	 */
	public List<User> queryByNameAndPwd(User user);

	public List<User> queryByNameAndPwd2(String name, String password);

	public List<User> queryByNameAndPwd3(@Param("name") String name, @Param("password") String password);

	/**
	 * ����һ������
	 * 
	 * @param user
	 * @return ���ز��������
	 */
	public int insert(User user);

	/**
	 * ����һ������
	 * 
	 * @param user
	 * @return ������Ӱ�������
	 */
	public int update(User user);

	/**
	 * ����idɾ����¼
	 * 
	 * @param id
	 * @return ɾ��������
	 */
	public int deleteById(long id);

}
