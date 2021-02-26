package com.bjpowernode.controll;

import java.io.IOException;
import java.io.PrintWriter;

public class BmiAjaxServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        System.out.println("=====接收了ajax的请求=====");

        //接收参数
        String strName = request.getParameter("name");
        String height = request.getParameter("h");
        String weight = request.getParameter("w");

                //计算bmi: bmi = 体重/身高的平方
        float h = Float.valueOf(height);
        float w = Float.valueOf(weight);
        float bmi = w/(h*h);

        //判断bmi的范围
        String msg = "";
        if(bmi <=18.5){
            msg="您比较瘦";
        }else if(bmi >18.5 && bmi<= 23.9){
            msg="您的bmi是正常的";
        }else if(bmi >24 && bmi<= 27){
            msg="您的身体比较胖";
        }else{
            msg="您的身体肥胖";
        }
        System.out.println("msg="+msg);
        msg = "你好："+strName+"先生/女士，您的bmi值是："+bmi+","+msg;

        //响应ajax需要的数据，  使用HttpServletResponse输出数据
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();
        //输出数据
        pw.println(msg);
        //清空缓存
        pw.flush();
        //关闭close
        pw.close();

        //接收请求参数
//        String strName = request.getParameter("name");
//        String height = request.getParameter("h");
//        String weight = request.getParameter("w");
//
//        //计算bmi: bmi = 体重/身高的平方
//        float h = Float.valueOf(height);
//        float w = Float.valueOf(weight);
//        float bmi = w/(h*h);
//
//        //判断bmi的范围
//        String msg = "";
//        if(bmi <=18.5){
//            msg="您比较瘦";
//        }else if(bmi >18.5 && bmi<= 23.9){
//            msg="您的bmi是正常的";
//        }else if(bmi >24 && bmi<= 27){
//            msg="您的身体比较胖";
//        }else{
//            msg="您的身体肥胖";
//        }
//        System.out.println("msg="+msg);
//        msg = "你好："+strName+"先生/女士，您的bmi值是："+bmi+","+msg;
//
//
//        //使用HttpServletResponse输出数据
//        response.setContentType("text/html;charset=utf-8");
//        //获取printWriter
//        PrintWriter pw = response.getWriter();
//        //输出数据
//        pw.println(msg);
//        //清空缓存
//        pw.flush();
//        //关闭close
//        pw.close();


    }
}
