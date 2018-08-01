package com.crawler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlerTest {

	public static void main(String[] args) throws IOException {
		//缓冲流的创建,以utf-8写入文本
		BufferedWriter writer = new BufferedWriter( new OutputStreamWriter( new FileOutputStream( new File("data/crawlerbitauto.txt")),"utf-8"));
		List<PostModel> data = crawerData("http://baa.bitauto.com/CS55/");
		for (PostModel model : data) {
			//所爬数据写入文本
			writer.write(model.getPost_id() + "\t" + model.getPost_title() + "\r\n");
		}
		//流的关闭
		writer.close();
	}
	static List<PostModel> crawerData(String url) throws IOException{
		//所爬数据封装于集合中
		List<PostModel> datalist = new ArrayList<PostModel>();
		//获取URL对应的HTML内容
		Document doc = Jsoup.connect(url).timeout(5000).get();
		//定位需要采集的每个帖子
		Elements elements = doc.select("div[class=line-bg]").select("div[class=postslist_xh]"); 
		//遍历每一个帖子
		for (Element ele : elements) {
			String post_id = ele.select("li.bt").select("a").attr("href").split("-")[1].replaceAll("\\D", "");
			String post_title = ele.select("li.bt").select("a").text();
			//创建对象和封装数据
			PostModel model = new PostModel();
			model.setPost_id(post_id);
			model.setPost_title(post_title);
			datalist.add(model);
		}
		return datalist;
	}
}
