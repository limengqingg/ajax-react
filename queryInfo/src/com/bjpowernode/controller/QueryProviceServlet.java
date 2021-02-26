package com.bjpowernode.controller;

import com.bjpowernode.dao.ProvinceDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class QueryProviceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理get请求

        String json ="{}" ;
        //获取参数proid
        String param = request.getParameter("proid");


        //访问dao，查询数据库
        if(param != null && !param.trim().isEmpty()){
            //创建dao对象，调用它的方法
            ProvinceDao dao = new ProvinceDao();
            Province pro = dao.selectProvinceObject(Integer.parseInt(param));
            if(pro!= null){
                ObjectMapper om = new ObjectMapper();
                json = om.writeValueAsString(pro);
            }
//            name = dao.queryProviceNameById(Integer.valueOf(strProid));
        }

        //响应ajax需要的数据，  使用HttpServletResponse输出数据
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        //输出数据
        //pw.println("中国");
        pw.println(name);
        //清空缓存
        pw.flush();
        //关闭close
        pw.close();
    }
}
