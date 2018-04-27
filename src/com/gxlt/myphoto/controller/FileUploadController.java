package com.gxlt.myphoto.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gxlt.myphoto.entity.PhotoGraph;
import com.gxlt.myphoto.entity.PhotoSort;
import com.gxlt.myphoto.entity.Picture;
import com.gxlt.myphoto.entity.User;
import com.gxlt.myphoto.service.IPhotoGraphService;
import com.gxlt.myphoto.service.IPictureService;

@Controller
public class FileUploadController {
//	@Autowired
//	private IPhotoSortService photoSortService;
	@Autowired
	private IPhotoGraphService  photoGraphService;
	
	@Autowired
	private IPictureService  pictureService;
	
	@RequestMapping("/uploadName")
	public String fileUpload(MultipartHttpServletRequest mreq,HttpServletRequest request) throws IOException{
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		PhotoSort sort = new PhotoSort();
		sort.setId(10);
		sort.setName("啥贷");
		sort.setUser(user);
		
//		PhotoGraph graph = new PhotoGraph();
//		graph.setName(name);
//		graph.setPhotoSort(sort);
//		graph.setUptime("2017-12-08");
//		int rows = photoGraphService.addPhoto(graph);
		
//		if(rows==1){
//			System.out.println("成功添加一张图片");
//		}
//		获取页面上的文件，对应input标签的name属性
//		支持多文件上传
		List<MultipartFile> files = mreq.getFiles("image");
			for (MultipartFile file : files) {
//				获取文件名
				String fileName=file.getOriginalFilename();
				System.out.println("fileName:"+fileName);
				//获取文件后缀名
				 String prefix=fileName.substring(fileName.lastIndexOf(".")+1);      
				 System.out.println("prefix:"+prefix);
				 fileName=System.currentTimeMillis()+"."+prefix;
//				创建image文件夹
//				String path=mreq.getServletContext().getRealPath("/")+"/image";
				String path="E:\\updir";
				File dir = new File(path);
				if(!dir.exists()){
					dir.mkdirs();
				}
				
				String uptime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
				PhotoGraph graph = new PhotoGraph();
				graph.setName(fileName);
				graph.setPhotoSort(sort);
				graph.setUptime(uptime);
				int rows = photoGraphService.addPhoto(graph);
				System.out.println("成功添加"+rows+"张图片");
//				输出文件到指定目录
				File out = new File(path+"/"+fileName);
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(out));
				bos.write(file.getBytes());
				bos.close();
			}
		return "/welcome.jsp";
	}
	
	@RequestMapping("/upload")
	public String uploadPhoto(MultipartHttpServletRequest mreq,HttpServletRequest request) throws IOException{
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		String albumName = request.getParameter("albumName");
		System.out.println("albumName:"+albumName);
/*		PhotoSort sort = new PhotoSort();
		sort.setId(10);
		sort.setName("啥贷");
		sort.setUser(user);*/
		
//		获取页面上的文件，对应input标签的name属性
//		支持多文件上传
		List<MultipartFile> files = mreq.getFiles("image");
			for (MultipartFile file : files) {
//				获取文件名
				String fileName=file.getOriginalFilename();
				System.out.println("fileName:"+fileName);
				//获取文件后缀名
				 String prefix=fileName.substring(fileName.lastIndexOf(".")+1);      
				 System.out.println("prefix:"+prefix);
				 fileName=System.currentTimeMillis()+"."+prefix;
//				创建image文件夹
//				String path=mreq.getServletContext().getRealPath("/")+"/image";
				String path="E:\\updir";
				File dir = new File(path);
				if(!dir.exists()){
					dir.mkdirs();
				}
				
				String uptime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
/*				PhotoGraph graph = new PhotoGraph();
				graph.setName(fileName);
				graph.setPhotoSort(sort);
				graph.setUptime(uptime);
				int rows = photoGraphService.addPhoto(graph);*/
//				System.out.println("成功添加"+rows+"张图片");
				Picture p=new Picture();
				p.setAlbumId(Long.parseLong(albumName));
//				p.setAlbumId(1l);
				p.setPhotoName(fileName);
				p.setUpTime(uptime);
				int addPhotoNum = pictureService.addPhoto(p);
				System.out.println("addPhotoNum:"+addPhotoNum);
				
//				输出文件到指定目录
				File out = new File(path+"/"+fileName);
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(out));
				bos.write(file.getBytes());
				bos.close();
			}
		return "/welcome.jsp";
	}
	
	@RequestMapping("/findTest")
	public String findTest(MultipartHttpServletRequest mreq,HttpServletRequest request) throws IOException{
		System.out.println("加载主页");
		HttpSession session = request.getSession();
		String str="201314";
		session.setAttribute("str", str);
		return "/upload.jsp";
	}
}
