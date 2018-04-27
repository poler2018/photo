package com.gxlt.myphoto.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.gxlt.myphoto.entity.PhotoAlbum;
import com.gxlt.myphoto.entity.Picture;
import com.gxlt.myphoto.entity.User;
import com.gxlt.myphoto.service.IPhotoAlbumService;
import com.gxlt.myphoto.service.IPhotoSortService;
import com.gxlt.myphoto.service.IPictureService;
import com.gxlt.myphoto.service.IUserService;
import com.gxlt.myphoto.util.FileHelper;

@Controller
@RequestMapping("/user")
public class LoginController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IPhotoAlbumService photoAlbumService;
	
	//
	@Autowired
	private IPictureService pictureService;
	
	@Autowired
	private IPhotoSortService photoSortService;
	@RequestMapping("/login")
	public String login(String username,String password,HttpServletRequest request) throws IOException{
		System.out.println("username:"+username+";password:"+password);
		User user = userService.login(username, password);
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		
		//添加相册
//		int insertAlbumName = photoAlbumService.insertAlbumName(new PhotoAlbum(user.getId(), "朋友"));
//		System.out.println("添加相册insertAlbumName:"+insertAlbumName);
		//查询相册
		List<PhotoAlbum> findAllById = photoAlbumService.findAllById((int) user.getId());
		for (PhotoAlbum photoAlbum : findAllById) {
			System.out.println("相册名："+photoAlbum.getAlbumName());
		}
		
		session.setAttribute("list", findAllById);
		
//		查询相片
		List<Picture> allPhoto = pictureService.findAllPhoto(user.getId());
		for (Picture picture : allPhoto) {
			System.out.println("picture:"+picture);
		}
		session.setAttribute("showlist", allPhoto);
		
		
		
//		System.out.println("user.getSort():"+user.getSort());
//		user.getSort();
//		List<PhotoSort> list = photoSortService.findById(user.getId());
//		List<PhotoSort> list = photoSortService.findAllByUid(user.getId());
//		for (PhotoSort photoSort : list) {
//			System.out.println("photoSort:"+photoSort);
//		}
//		request.setAttribute("list", list);
		
		String path = "E:\\updir";
		String tomcatpath ="D:/myapp/tomcat/apache-tomcat-7.0.82-windows-x64/apache-tomcat-7.0.82/webapps/Photo/upload/";
		//图片复制到tomcat服务器
		 new FileHelper(path,tomcatpath);
		return "/welcome.jsp";
	}
	
	@RequestMapping("/register")
	public String register(String username,String password,HttpServletRequest request){
		System.out.println("username:"+username+";password:"+password);
		int rows = userService.register(username, password);
		System.out.println("成功插入了"+rows+"条数据");
//		User user = userService.login(username, password);
//		request.setAttribute("user", user);
		return "/login.jsp";
	}
}
