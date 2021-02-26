
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>ajax使用json格式的数据</title>
    <script type="text/javascript">
      function  doSearch() {
        var proid = document.getElementById("proid").value;
        //发起ajax请求，传递参数给服务器，服务器返回数据
        //创建异步对象方式
        var xmlHttp = new XMLHttpRequest();
        //2.绑定事件
        xmlHttp.onreadystatechange= function() {
          //处理服务器端返回的数据，更新当前页面
          // alert(xmlHttp.readyState);
          //alert("readyState属性值==="+xmlHttp.readyState + "| status:"+xmlHttp.status)
          if( xmlHttp.readyState == 4 && xmlHttp.status == 200){
            //处理服务器返回数据,更新当前页面
            var respText = xmlHttp.responseText;
            //将json格式字符串转为json object对象
            var jsonobj = eval("("+respText+")");
            //处理结果函数
            callback(jsonobj);
          }
        }


        //3.初始化请求数据
        //获取dom对象的value属性值
        // var proid = document.getElementById("proid").value;

        // var param = "proid="+proid;
        // alert("param="+param);
        //true:异步处理请求。使用异步对象发起请求后，不用等待数据处理完毕，就可以执行其它的操作。
        //false: 同步，异步对象必须处理完成请求，从服务器端获取数据后，才能执行send之后的代码
        xmlHttp.open("get","searchProvinceJson?proid="+proid,false);
        //4.发起请求
        xmlHttp.send();

        //也可以创建其他的XMLHttpRequest,发送其他的请求处理
        alert("====在send之后的代码====")
      }

      function callback(jsonobj) {
        document.getElementById("proname").value = jsonobj.name;
        document.getElementById("projiancheng").value = jsonobj.jiancheng;
        document.getElementById("proshenghui").value = jsonobj.shenghui;

      }
    </script>
  </head>
  <body>
     <p>使用json格式的数据</p>
     <table>
       <tr>
         <td>省份编号：</td>
         <td><input type="text" id="proid"></td>
         <input type="button" value="搜索" onclick="Search()">
       </tr>
       <tr>
         <td>省份名称：</td>
         <td><input type="text" id="proname"></td>
       </tr>
       <tr>
         <td>省份简称：</td>
         <td><input type="text" id="projiancheng"></td>
       </tr>
       <tr>
         <td>省会名称：</td>
         <td><input type="text" id="proshenghui"></td>
       </tr>
     </table>
  </body>
</html>
