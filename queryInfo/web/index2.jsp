
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>ajax根据省份id获取名称</title>
    <script type="text/javascript" src="/js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
      $(function(){
        $("#addProvince").click(function(){
          $.ajax({
            url:"queryProvince",
            type:'GET',
            dataType:'json',
            success:function (result) {
              $("#province").empty();
              $("#province").append(
                      "<option value='0'>请选择。。。</option>"
              );
              $.each(result,function(i,n){
                $("#province").append(
                        "<option value='"+n.id+"'>"+n.name+"</option>"
                )
              })
            },
            error:function(xhr,status,error){
              alert("请求错误："+error)
            }
          })
        })

        //选择省份，查询城市列表
        $("#province").on("change",function(){
          var proId = $("#province>option:selected").val();
          if(proId == '0'){
            alert("请选择一个有效的省份")
          }else{
            $.post("queryCity",{proId:proId},callback,"json");
          }
        })
        function callback(result){
          $("#city").empty();
          $("#city").append(
                  "<option value='0'>请选择。。。。</option>"
          );
          $.each(result,function(i,n){
            $("#city").append(
                    "<option value='"+n.id+"'>"+n.name+"</option>"
            )
          })
        }

      })
      }
    </script>
  </head>
  <body>
    <div align="center">
      <table>
        <tr>
          <td>省份列表：</td>
          <td>
            <select id="province">
              <option value="0">请选择。。。</option>
            </select>
          </td>
          <td><button id="addProvince">获取省名</button></td>
        </tr>
        <td>城市列表：</td>
        <td>
          <select id="city">
            <option value="0">请选择。。。。</option>
          </select>
        </td>
      </table>

    </div>
  </body>
</html>
