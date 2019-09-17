package club.ldolin.day3.Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupDemo {
    public static void main(String[] args) throws IOException {
        //1.导入jar包
        //2.获取Document对象
        //2.1.获取路径
//        String path=JsoupDemo.class.getClassLoader().getResource("/student.xml").getPath();
        String path = "D:\\IntelliJ IDEA 2018.2.6\\IdeaProjects\\learn_day3\\src\\student.xml";
//        System.out.println(path);
        //2.2.解析xml，加载xml进内存，获取dom树--》document
        Document document = Jsoup.parse(new File(path),"utf-8");
        //3.获取元素对象Element
        Elements elements = document.getElementsByTag("name");
        System.out.println(elements.size());
        //3.1获取数据
        Element element = elements.get(0);
        String name = element.text();

        System.out.println(name);

    }
}
