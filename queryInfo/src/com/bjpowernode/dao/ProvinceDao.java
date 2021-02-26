package com.bjpowernode.dao;

import java.sql.*;

//使用jdbc访问数据库
public class ProvinceDao {

    //根据id获取一个完整的Province对象
    public Province queryProviceById(Integer proviceId){
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "";
        String url="jdbc:mysql://localhost:3306/springdb";
        String userName = "root";
        String password = "123456";


        Province  province = null;

        //加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("url",userName,password);
            //创建PrepareStatement
            sql = "select id, name, jiancheng, shenghui from province where id=?";
            pst = conn.prepareStatement(sql);
            //设置参数值
            pst.setInt(1,proviceId);
            //执行sql
            rs = pst.executeQuery();
            //遍历rs
            while (rs.next()){
                //当你的rs中有多余一条记录时
//                name = rs.getString("name");
                province = new Province();
                province.setId(rs.getInt("id"));
                province.setName(rs.getString("name"));
                province.setJiancheng(rs.getString("jiancheng"));
                province.setShenghui(rs.getString("shenghui"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null){
                    rs.close();
                }
                if (pst != null){
                    pst.close();
                }
                if (conn != null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return  province;
    }
}
