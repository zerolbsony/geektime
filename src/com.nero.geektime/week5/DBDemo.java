package com.nero.geektime.week5;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBDemo {

    public static void main(String[] args) throws Exception {
        //1.注册驱动
        // 使用java.sql.DriverManager类的静态方法registerDriver(Driver driver)
        // Driver是一个接口,参数传递:MySQL驱动程序的实现类
        // DriverManager.registerDriver(new Driver());
        // 查看驱动类源码,注册两次驱动,浪费资源
        Class.forName("com.mysql.jdbc.Driver");

        //2.获得连接
        String url = "jdbc:mysql://localhost:3306/demo";

        // static Connection getConnection(String url, String user, String password)
        // 返回值是java.sql.Connection接口的实现类,在MySQL驱动程序中
        Connection conn = DriverManager.getConnection(url, "root", "root");
        System.out.println(conn);

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
        int row =
            stat.executeUpdate("INSERT INTO user(`name`, sex, age) VALUES ('小明', 'male', 20),('小王', 'female', 22)");
        System.out.println(row);

        int row1 = stat.executeUpdate("UPDATE user SET `name` = '小张' WHERE `name` = '小明'");
        System.out.println(row1);

        String sql = "select * from sort";

        // 4.调用执行者对象方法,执行SQL语句获取结果集
        // 返回的是ResultSet接口的实现类对象,实现类在mysql驱动中
        ResultSet rs = stat.executeQuery(sql);
        // System.out.println(rs);//com.mysql.jdbc.JDBC4ResultSet@18cef0a
        // 5.处理结果集
        // ResultSet接口的方法 boolean next() 有结果集true,没有结果集返回false
        while (rs.next()) {
            // 获取每列的数据,使用的是ResultSet接口的方法getXXX
            /**
             * int java.sql.ResultSet.getInt(String columnLabel) throws SQLException
             *
             * Retrieves the value of the designated column in the current row of this ResultSet object as an int in the Java programming language.
             *
             * Parameters:
             *
             * columnLabel the label for the column specified with the SQL AS clause. If the SQL AS clause was not specified, then the label is the name of the column
             *
             * Returns:
             *
             * the column value; if the value is SQL NULL, the value returned is 0
             *
             * Throws:
             *
             * SQLException - if the columnLabel is not valid; if a database access error occurs or this method is called on a closed result set
             */
            int sid = rs.getInt("id");// 相当于rs.getInt(1);这个方法有弊端（当为null时会返回0）
            String name = rs.getString("name");
            String sex = rs.getString("sex");
            int age = rs.getInt("age");

            System.out.println(sid + "\t" + name + "\t" + sex + "\t" + age);

        }

        int row2 = stat.executeUpdate("DELETE FROM user WHERE `name` = '小张'");
        System.out.println(row2);

        String sql1 = "UPDATE user SET age=? WHERE `name`=?";
        // 4.调用数据库连接对象con的方法prepareStatement获取SQL语句的预编译对象
        PreparedStatement pst = conn.prepareStatement(sql1);
        // 5.调用pst的方法setXXX设置?占位
        pst.setObject(1, 25);
        pst.setObject(2, "小王");
        // 6.调用pst方法执行SQL语句
        pst.executeUpdate();

        if (Math.random() % 10 == 1) {
            conn.commit();
        } else {
            conn.rollback();
        }

        //释放资源
        pst.close();
        rs.close();
        stat.close();
        conn.close();

        //连接池
        // 如何获得属性文件的输入流？
        // 通常情况下使用类的加载器的方式进行获取：
        try (InputStream is = DBDemo.class.getClassLoader().getResourceAsStream("hikari.properties")) {
            // 加载属性文件并解析：
            Properties props = new Properties();
            props.load(is);
            HikariConfig config = new HikariConfig(props);
            HikariDataSource source = new HikariDataSource(config);

            Connection con = source.getConnection();

            String sql2 = "UPDATE user SET age=? WHERE `name`=?";
            // 4.调用数据库连接对象con的方法prepareStatement获取SQL语句的预编译对象
            PreparedStatement ps = conn.prepareStatement(sql1);
            // 5.调用pst的方法setXXX设置?占位
            ps.setObject(1, 26);
            ps.setObject(2, "小王");
            // 6.调用pst方法执行SQL语句
            ps.executeUpdate();
            con.createStatement();

            if (Math.random() % 10 == 1) {
                con.commit();
            } else {
                con.rollback();
            }

            //close
            ps.close();
            con.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
