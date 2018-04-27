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
		
		//������
//		int insertAlbumName = photoAlbumService.insertAlbumName(new PhotoAlbum(user.getId(), "����"));
//		System.out.println("������insertAlbumName:"+insertAlbumName);
		//��ѯ���
		List<PhotoAlbum> findAllById = photoAlbumService.findAllById((int) user.getId());
		for (PhotoAlbum photoAlbum : findAllById) {
			System.out.println("�������"+photoAlbum.getAlbumName());
		}
		
		session.setAttribute("list", findAllById);
		
//		��ѯ��Ƭ
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
		//ͼƬ���Ƶ�tomcat������
		 new FileHelper(path,tomcatpath);
		return "/welcome.jsp";
	}
	
	@RequestMapping("/register")
	public String register(String username,String password,HttpServletRequest request){
		System.out.println("username:"+username+";password:"+password);
		int rows = userService.register(username, password);
		System.out.println("�ɹ�������"+rows+"������");
//		User user = userService.login(username, password);
//		request.setAttribute("user", user);
		return "/login.jsp";
	}
}
