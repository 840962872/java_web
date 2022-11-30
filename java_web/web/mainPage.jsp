<%--
  Created by IntelliJ IDEA.
  User: 84096
  Date: 2022/11/29
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>主界面</title>
    <style>
        #head_{
            height: 100px;
            width: 100%;
            background-color: slategray;
        }
        #personFile{
            width: 120px;
            height: 50px;
            padding-top: 25px;
            margin-left: 90%;
        }
        #search{
            height: 70px;
            width: 100%;
            background-color: cornflowerblue;
        }
        #inner_s{
            /*width: 200px;
            height: 40px;
            padding-right: 70%;
            padding-top: 50%;*/
            width: 30%;
            padding-top:25px;
            padding-left: 45%;
        }
        #table{
            margin-left: 30%;
            margin-top: 30px;
        }
        td{
            text-align: center;
            height: 20px;
            width: 150px;
            border: black 1px solid;
            padding:1px;

        }

    </style>

    <script>
        function search(){
            let v = document.getElementById("fileid").value;
            //alert(v)

            window.location.href = "mainServlet?v=" + v +"&id=${user.getU_id()}";
        }

        function goShow(v){
            window.location.href = "show?v="+v+"&id=${user.getU_id()}";
        }
        function  del(v){
            let isdel = confirm("是否删除这个同学？")
            if(isdel){

                window.location.href = "del?v="+v+"&id=${user.getU_id()}";
            }else {
                return;
            }

        }
        function update(v){

            window.location.href = "update?stuId="+v+"&id=${user.getU_id()}";
        }

    </script>


</head>
<body>

<div id="head_">
    <div id="personFile">
        名字:<span style="color: red">${user.getU_name()}</span><br>
        编号:<span style="color: red">${user.getU_id()}</span>
    </div>
</div>


<div id="search">
    <div id="inner_s">
        <input id="fileid" type="text" style="font-size: 20px; height: 26px;width: 190px">&nbsp;&nbsp;
        <button style="font-size: 18px; height: 28px;" onclick="search()">查询</button>
    </div>
</div>

<div>
    <table id="table" style="height: 30px;width: 700px;border: black 1px solid;border-collapse:collapse;">



        <tr >
            <td>学生id</td>
            <td>学生名字</td>
            <td>学生电话</td>
            <td>查看成绩</td>
            <td>操作</td>
        </tr>

        <c:forEach items="${arrUser}" var="item">
            <tr>
                <td>${item.getU_id()}</td>
                <td>${item.getU_name()}</td>
                <td>${item.getU_phone()}</td>
                <td><button style="color: chocolate" onclick="goShow(${item.getU_id()})">查看成绩</button></td>
                <td><button style="color: chocolate" onclick="update(${item.getU_id()})">修改</button>
                    <button style="color: chocolate" onclick="del(${item.getU_id()})">删除</button>
                </td>
            </tr>

        </c:forEach>



    </table>
</div>


<div>

</div>

</body>
</html>

