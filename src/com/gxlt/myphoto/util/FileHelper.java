package com.gxlt.myphoto.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class  FileHelper {
	public FileHelper(String url1,String url2) throws IOException{
		(new File(url2)).mkdirs(); // ����Ŀ���ļ���
		File[] file = (new File(url1)).listFiles(); // ��ȡԴ�ļ��е�ǰ�µ��ļ���Ŀ¼
		for (int i = 0; i < file.length; i++) {
			if (file[i].isFile()) // �����ļ�
			{
				String type = file[i].getName().substring(file[i].getName().lastIndexOf(".") + 1);
				copyFile(file[i], new File(url2 + file[i].getName()));
			}
		}
//		System.out.println("�ļ����Ƴɹ�");
	}

	// �����ļ�
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
