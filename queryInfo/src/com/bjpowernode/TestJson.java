package com.bjpowernode;

public  class TestJson{
    public static  void main(String[] args){

        //使用jackson 把java对象转为json格式的字符串

        Province p = new Province();
        p.setId(1);
        p.setName("河北");
        p.setJiancheng("冀");
        p.setShenghui("石家庄");

        //使用jackson把p转为json

        ObjectMapper om = new ObjectMapper();
        //writeValueAsString：把参数的java对象转为json格式的字符串
        String json=om.writeValueAsString(p);

        System.out.println("转换的json=="+json);

    }
}