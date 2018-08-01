package com.file;

import java.io.File;

public class FileTest {

	public static void main(String[] args) {
		File root = new File("data/");
		//判断文件是否问一个目录
		Boolean is_directory = root.isDirectory();
		System.out.println(root.isDirectory());
		//如果是一个目录
		if (is_directory) {
			//获取目录下所有文件和目录的绝对路径，得到的是File数组
			File[] files = root.listFiles(); 
			for ( File file : files ){
				System.out.println("文件名称为:" + file.getName());
				System.out.println("文件可读否:" + file.canRead());
				System.out.println("绝对路径:"+file.getAbsolutePath());
			    System.out.println("文件的长度为:" + file.length());
			}
		}
	}
}
