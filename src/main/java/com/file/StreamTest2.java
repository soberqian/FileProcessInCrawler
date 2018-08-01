package com.file;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StreamTest2 {

	public static void main(String[] args) throws IOException {
		//两种文件字符输入流创建方式
				FileReader fileReader = new FileReader("data/3.txt");
				//FileReader fileReader = new FileReader(new File("data/1.txt"));
				//两种文件字符输出流创建方式
				FileWriter fileWriter = new FileWriter("data/outtest.txt");
				//FileWriter fileWriter = new FileWriter(new File("data/outtest.txt"));
				int temp;
				while ((temp = fileReader.read()) != -1) {
					System.out.print((char)temp);
					fileWriter.write((char)temp);
				}
				fileWriter.close();
				fileReader.close();
	}
}
