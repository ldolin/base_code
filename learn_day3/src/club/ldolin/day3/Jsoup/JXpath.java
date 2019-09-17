package club.ldolin.day3.Jsoup;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


import java.io.File;
import java.io.IOException;
import java.util.List;

public class JXpath {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
        //1.获取路径
        String path = "D:\\IntelliJ IDEA 2018.2.6\\IdeaProjects\\learn_day3\\src\\student.xml";
        //2.解析xml，加载xml进内存，获取dom树--》document
        Document document = Jsoup.parse(new File(path),"utf-8");
        //3.根据document对象，创建Jxdocument对象
        JXDocument jxDocument = new JXDocument(document);
        //4.结合xpath查询结合
        //4.1.查询所有student标签
        List<JXNode> jxNodes = jxDocument.selN("//student[@number='heima_0001']/name/text()");
        for (JXNode jxNode : jxNodes) {
            System.out.println(jxNode);
        }

    }
}
