package club.ldolin.test;

import club.ldolin.domain.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.util.*;

public class JacksonTest {
    //java对象转json字符串
    @Test
    public void test1() throws Exception {
        //1.创建person对象
        Person p = new Person();
        p.setName("杨");
        p.setAge(21);
        p.setGender("男");
        //2.创建Jackson核心对象，ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        //3.转换
        /**
         * 转换方法
         * writeValue(参数1，obj):
         * 参数1
         * 1.File:将obj对象转为json字符串，并保存到指定的文件中
         * 2.Write:将obj对象转为json字符串，并将json数据填充到字符输出流中
         * 3.OutputStream:将obj对象转为json字符串，并将json数据填充到字节输出流中
         * writeValueAsString(obj):将对象转换为json字符串
         */
        String json = mapper.writeValueAsString(p);
//        System.out.println(json);
        //将数据写入a.txt
//        mapper.writeValue(new File("d://a.txt"),p);
        //将数据关联到Writer中
        mapper.writeValue(new FileWriter("d://b.txt"),p);
    }

    @Test
    public void test2() throws Exception {
        //1.创建person对象
        Person p = new Person();
        p.setName("杨");
        p.setAge(21);
        p.setGender("男");
        p.setBirthday(new Date());
        //2.转换
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(p);
        System.out.println(json); //{"name":"杨","age":21,"gender":"男","birthday":1566888915993}
    }

    @Test
    public void test3() throws Exception {
        //1.创建person对象
        Person p = new Person();
        p.setName("杨");
        p.setAge(21);
        p.setGender("男");
        p.setBirthday(new Date());

        Person p1 = new Person();
        p1.setName("杨");
        p1.setAge(21);
        p1.setGender("男");
        p1.setBirthday(new Date());

        Person p2 = new Person();
        p2.setName("杨");
        p2.setAge(21);
        p2.setGender("男");
        p2.setBirthday(new Date());

        //创建list集合
        List<Person> ps = new ArrayList<Person>();
        ps.add(p);
        ps.add(p1);
        ps.add(p2);
        //2.转换
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(ps);
//[{"name":"杨","age":21,"gender":"男","birthday":"2019-08-27"},{"name":"杨","age":21,"gender":"男","birthday":"2019-08-27"},{"name":"杨","age":21,"gender":"男","birthday":"2019-08-27"}]
        System.out.println(json);
    }

    @Test
    public void test4() throws Exception {
        //1.创建map对象
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name","杨");
        map.put("age",21);
        map.put("gender","男");

        //2.转换
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(map);
        System.out.println(json);
    }

    @Test
    public void test5() throws Exception {
        //json字符串转java对象
        //1.初始化json1字符串
        String json = "{\"gender\":\"男\",\"name\":\"杨\",\"age\":21}";
        //2.创建Jackson核心对象，ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        //3.转换为java对象，Person对象
        Person person = mapper.readValue(json, Person.class);
        System.out.println(person);

    }
}
