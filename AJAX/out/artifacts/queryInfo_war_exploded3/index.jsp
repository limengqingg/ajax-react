
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>ajax根据省份id获取名称</title>
    <script type="text/javascript">
      function  search() {
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
            alert(xmlHttp.responseText);
          }
        }

        //3.初始化请求数据
        //获取dom对象的value属性值
        var proid = document.getElementById("proid").value;

        // var param = "proid="+proid;
        // alert("param="+param);
        xmlHttp.open("get","queryProvice?proid="+proid,true);
        //4.发起请求
        xmlHttp.send();
      }
    </script>
  </head>
  <body>
     <p>ajax根据省份id获取名称</p>
     <table>
       <tr>
         <td>省份编号：</td>
         <td><input type="text" id="proid"></td>
         <input type="button" value="搜索" onclick="search()">
       </tr>
       <tr>
         <td>省份名称：</td>
         <td><input type="text" id="proname"></td>
       </tr>
     </table>
  </body>
</html>
