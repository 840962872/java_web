<%--
  Created by IntelliJ IDEA.
  User: 84096
  Date: 2022/11/29
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆界面</title>
    <style>
        #frame_{
            margin-left: 500px;
            margin-top: 300px;
        }

    </style>

</head>
<body>
<div id="frame_">
  用户id:<input type="text" id="u_id"><br>
  密码:<input type="password" id="u_pwd"><br>
  <button id="btn01">重置</button><button id="btn02">登录</button><br>
    <span id="error" style="color: red">${error}</span>
    <script>
        let btn02 = document.getElementById("btn02");
        btn02.onclick = function (){
            //获取id pwd是否为空
            let id_str = document.getElementById("u_id").value;
            if(id_str == null || id_str == ""){
                alert("id不能为空")
                document.getElementById("error").innerHTML="id不能为空！"
                return
            }
            let pwd_str = document.getElementById("u_pwd").value;
            if(pwd_str == null || pwd_str == ""){
                alert("pwd不能为空")
                document.getElementById("error").innerHTML="pwd不能为空！"
                return
            }
            //开始访问服务器
            window.location.href = "login?u_id="+id_str+"&u_pwd="+pwd_str;

        }


    </script>

</div>
</body>
</html>
