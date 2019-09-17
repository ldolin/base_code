package club.ldolin.day1.JdbcTemp;

import club.ldolin.day1.druid.DruidToolClass;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class JdbcTempDemo {
    public static void main(String[] args) {
        //1.导入jar包
        //2.创建JdbcTemplate对象
        JdbcTemplate template = new JdbcTemplate(DruidToolClass.getDataSource());

        //3.调用方法
        String sql = "update zhanghu set balance=4000 where id=?";
        int count = template.update(sql,3);
        System.out.println(count);
    }
    //Junit单元测试--map返回结果集只能为1
    @Test
    public void test(){
        JdbcTemplate template = new JdbcTemplate(DruidToolClass.getDataSource());

        //3.调用方法
        String sql = "update zhanghu set balance=? where id=?";
        int count = template.update(sql,2000,1);
        System.out.println(count);
    }
    @Test
    public void test1(){
        JdbcTemplate template = new JdbcTemplate(DruidToolClass.getDataSource());

        //3.调用方法
        String sql = "select * from zhanghu where id=?";
        Map<String,Object> map = template.queryForMap(sql,1);
        System.out.println(map);
    }
    @Test
    public void test2(){
        JdbcTemplate template = new JdbcTemplate(DruidToolClass.getDataSource());

        //3.调用方法
        String sql = "select * from zhanghu";
        List<Map<String,Object>> list = template.queryForList(sql);
        for (Map<String,Object> map:list) {
            System.out.println(map);
        }
        System.out.println(list);
    }
// 讲javabean封装成list
//    @Test
//    public void test3(){
//        JdbcTemplate template = new JdbcTemplate(DruidToolClass.getDataSource());
//        //3.调用方法
//        String sql = "select * from zhanghu";
//        List<Emp> list = template.query(sql,new BeanPropertyRowMapper<Emp>(Emp.class));
//        for (Emp emp : list) {
//            System.out.println(emp);
//        }
//    }
    @Test
    public void test3(){
        JdbcTemplate template = new JdbcTemplate(DruidToolClass.getDataSource());

        //3.调用方法
        String sql = "select count(id) from zhanghu";
        Long total = template.queryForObject(sql,Long.class);
        System.out.println(total);
    }


}
