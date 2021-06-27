package com.nero.geektime;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Formatter;
import java.util.Random;

public class DBTest {

    @Test
    public static void batchInsert() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            //2.获得连接
            String url =
                "jdbc:mysql://localhost:3306/my_mall?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC&rewriteBatchedStatements=true";

            // static Connection getConnection(String url, String user, String password)
            // 返回值是java.sql.Connection接口的实现类,在MySQL驱动程序中
            Connection conn = DriverManager.getConnection(url, "root", "12345678");

            //设置防止自动提交事务
            conn.setAutoCommit(false);

            // 3. 获得语句执行平台,通过数据库连接对象,获取到SQL语句的执行者对象
            //conn对象,调用方法 Statement createStatement() 获取Statement对象,将SQL语句发送到数据库
            //返回的是Statement接口的实现类对象,在MySQL驱动程序中
            Statement stat = conn.createStatement();
            System.out.println(stat);

            // 4. 执行sql语句
            //通过执行者对象调用方法执行SQL语句,获取结果
            //int executeUpdate(String sql)  执行数据库中的SQL语句,仅限于insert,update,delete
            //返回值int,操作成功数据库的行数

            int orderNo = 1000002;
            int userId = 1;
            int payId = 1;
            int productAmount = 1000;

            String sql =
                "insert into orders (order_no, order_status, user_id, pay_no, pay_id, product_amount, product_total_price) values (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);

            Formatter f = new Formatter();
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < 1000000; i++) {
                pst.setObject(1, orderNo + i);
                pst.setObject(2, 0);
                pst.setObject(3, userId + i);
                pst.setObject(4, "");
                pst.setObject(5, payId + i);
                pst.setObject(6, 1000 * (new Random().nextInt() * (10 - 1 + 1) + 1));
                pst.setObject(7, 1000 * (new Random().nextInt() * (10 - 1 + 1) + 1));
                pst.addBatch();
            }
            pst.executeBatch();
            long endTime = System.currentTimeMillis();
            System.out.println("cost time is " +( endTime - startTime / 1000) + " seconds");

            pst.close();
            conn.close();
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        batchInsert();
    }
}