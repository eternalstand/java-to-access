package com.example.demo;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 简单测试access数据库连接
 */
@RestController
public class TestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/query")
    public String query() {
        List<Map<String, Object>> result = jdbcTemplate.queryForList("select * from test ");

        return JSON.toJSONString(result);
    }

    @RequestMapping("/insert")
    public String insert() {

        jdbcTemplate.execute("insert into test(id,name,age) values (10,'a','b');");

        return "success";
    }

//    @RequestMapping("/test2")
//    public String test2() {
//        //定义需要的对象
//        PreparedStatement ps=null;
//        Connection ct=null;
//        ResultSet rs=null;
//
//        try {
//            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//            String url = "jdbc:ucanaccess://D:\\test.accdb";
//            ct = DriverManager.getConnection(url, "", "");//没有用户名和密码的时候直接为空
//            ps=ct.prepareStatement("select * from test");
//            rs=ps.executeQuery();
//            if(rs.next()){
//                System.out.println("纯java代码实现:" + rs.getString("a"));
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//
//        return "fail";
//
//    }


}
