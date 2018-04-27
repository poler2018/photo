package com.gxlt.myphoto.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gxlt.myphoto.entity.PhotoAlbum;
import com.gxlt.myphoto.entity.PhotoGraph;
import com.gxlt.myphoto.entity.PhotoSort;
import com.gxlt.myphoto.entity.Picture;
import com.gxlt.myphoto.entity.User;
import com.gxlt.myphoto.service.IPhotoAlbumService;
import com.gxlt.myphoto.service.IPhotoGraphService;
import com.gxlt.myphoto.service.IPhotoSortService;
import com.gxlt.myphoto.service.IPictureService;
@Controller
public class PhotoController {
	@Autowired
	private IPhotoSortService photoSortService;
	@Autowired
	private IPhotoGraphService  photoGraphService;
	
	@Autowired
	private IPhotoAlbumService photoAlbumService;
	
	@Autowired
	private IPictureService pictureService;
	
	
	@RequestMapping("/addSort")
	public String addSort(String name,HttpServletRequest request){
//		User user = (User) request.getAttribute("user");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		System.out.println("addsortAction:"+user);
		System.out.println("name:"+name);
		PhotoSort sort = new PhotoSort();
		sort.setName(name);
		sort.setUser(user);
		System.out.println("�������ǰ��"+sort);
//		List<PhotoSort> list = photoSortService.findById(1l);
//		for (PhotoSort photoSort : list) {
//			System.out.println("photoSort:"+photoSort);
//		}
		
//		int rows = photoSortService.addSort(sort);
		int rows = photoSortService.addSortByNameAndUid(sort);
		if(rows==1){
			System.out.println("�ɹ�����"+rows+"��");
			request.setAttribute("tips", "������ɹ���");
		}
		return "../welcome.jsp";
	}
	
	@RequestMapping("/addPhoto")
	public String addPhoto(String name,HttpServletRequest request){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
//		PhotoSort sort = new PhotoSort();
//		sort.setId(10);
//		sort.setName("ɶ��");
//		sort.setUser(user);
//		
//		PhotoGraph graph = new PhotoGraph();
//		graph.setName(name);
//		graph.setPhotoSort(sort);
//		graph.setUptime("2017-12-08");
//		int rows = photoGraphService.addPhoto(graph);
//		
//		if(rows==1){
//			System.out.println("�ɹ����һ��ͼƬ");
//		}
		
		//������
		int insertAlbumName = photoAlbumService.insertAlbumName(new PhotoAlbum(user.getId(), name));
		System.out.println("������insertAlbumName:"+insertAlbumName);
		
		return "welcome.jsp";
	}
	
	//��ѯ��Ƭ
	@RequestMapping("/findPhoto")
	public String findPhoto(HttpServletRequest request){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		//���ղ�ѯ���������
		String albumName = request.getParameter("albumName");
		System.out.println("Ҫ���ҵ�albumName��"+albumName);
		
//		��ѯ��Ƭ
		List<Picture> findByAlbum = pictureService.findPhotoByAlbum(user.getId(), albumName);
		for (Picture picture : findByAlbum) {
			System.out.println("Ҫ���ҵ�picture:"+picture);
		}
		session.setAttribute("findByAlbum", findByAlbum);
		
		
		return "albumpicshow.jsp";
	}
}
