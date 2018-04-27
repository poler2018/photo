package com.gxlt.myphoto.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class  FileHelper {
	public FileHelper(String url1,String url2) throws IOException{
		(new File(url2)).mkdirs(); // 创建目标文件夹
		File[] file = (new File(url1)).listFiles(); // 获取源文件夹当前下的文件或目录
		for (int i = 0; i < file.length; i++) {
			if (file[i].isFile()) // 复制文件
			{
				String type = file[i].getName().substring(file[i].getName().lastIndexOf(".") + 1);
				copyFile(file[i], new File(url2 + file[i].getName()));
			}
		}
//		System.out.println("文件复制成功");
	}

	// 复制文件
	public  void copyFile(File sourceFile, File targetFile) throws IOException {
		BufferedInputStream inBuff = null;
		BufferedOutputStream outBuff = null;
		try {
			inBuff = new BufferedInputStream(new FileInputStream(sourceFile));
			outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));
			byte[] b = new byte[1024 * 5];
			int len;
			while ((len = inBuff.read(b)) != -1) {
				outBuff.write(b, 0, len);
			}
			outBuff.flush();
		} finally {
			if (inBuff != null)
				inBuff.close();
			if (outBuff != null)
				outBuff.close();
		}
	}
}
