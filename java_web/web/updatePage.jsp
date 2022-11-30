<%--
  Created by IntelliJ IDEA.
  User: 84096
  Date: 2022/11/30
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<style>
    #a{
        width: 70%;
        height: 600px;
        background-color: lemonchiffon;
        margin-left: 240px;
        margin-top: 50px;
        position: absolute;
    }
    #b{
        margin-left: 300px;
        margin-top: 100px;
    }
    input{
        margin-top: 15px;
        margin-left: 70px;
        font-size: 30px;
        color: red;
        font-family: 华文中宋;
    }
    button{
        background-color: azure;
        width: 100px;height: 25px;
        font-size: 20px;
        font-family: "Adobe 黑体 Std R";
        margin-left: 110px;
    }
    span{
        margin-left: 100px;
        color: red;
    }
</style>
<script>
    function goMainPage(){
        window.location.href = "gomainPage?admid=${admid}"
    }
    function sureUpdate(){
        let a1 = document.getElementById("a1").value;
        let a2 = document.getElementById("a2").value;
        let a3 = document.getElementById("a3").value;
        window.location.href = "updateStuInfo?admid=${admid}&stuid=${stuid}&a1="+a1+"&a2="+a2+"&a3="+a3;
    }
</script>
<body>
<div id="a">
    <div style="font-size: 40px;margin-top: 40px;margin-left: 70px">成绩修改界面</div>
    <span>学生：&nbsp; ${stuid}</span>
    <span>管理员：&nbsp; ${admid}</span>
    <div id="b">
        1001(计算机网络):&nbsp;<input type="text" id="a1"><br>
        <br>
        1002(深度学习):&nbsp;<input type="text" id="a2"><br>
        <br>
        1003(R语言):&nbsp;<input type="text" id="a3"><br>
        <br>
        <button onclick="goMainPage()">回主界面</button>&nbsp;&nbsp;
        <button onclick="sureUpdate()">确认修改</button>
    </div>

</div>
</body>
</html>
