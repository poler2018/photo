package com.gxlt.myphoto.service;
import com.gxlt.myphoto.entity.User;
public interface IUserService {
	public User login(String username, String password);
	public int register(String username, String password);
}
