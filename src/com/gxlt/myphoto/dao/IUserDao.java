package com.gxlt.myphoto.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import com.gxlt.myphoto.entity.User;

@MapperScan
public interface IUserDao {
	/**
	 * 通过id查询，返回User对象
	 * 
	 * @param id
	 * @return
	 */
	public User queryById(int id);

	/**
	 * 通过用户名密码查询
	 * 
	 * @return
	 */
	public List<User> queryByNameAndPwd(User user);

	public List<User> queryByNameAndPwd2(String name, String password);

	public List<User> queryByNameAndPwd3(@Param("name") String name, @Param("password") String password);

	/**
	 * 插入一个对象
	 * 
	 * @param user
	 * @return 返回插入的条数
	 */
	public int insert(User user);

	/**
	 * 更新一个对象
	 * 
	 * @param user
	 * @return 返回受影响的条数
	 */
	public int update(User user);

	/**
	 * 根据id删除记录
	 * 
	 * @param id
	 * @return 删除的条数
	 */
	public int deleteById(long id);

}
