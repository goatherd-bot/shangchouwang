<%--
  Created by IntelliJ IDEA.
  User: 86177
  Date: 2021/10/3
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<a href="test/ssm.html">测试SSM整合环境</a><br>
<button id="btn1">Send [1,3,6] One</button><br>
<button id="btn2">Send [1,4,3] two</button><br>
<button id="btn3">Send [1,2,3] three</button><br>
<button id="btn4">Send [1,2,3] four</button><br>
<button id="btn5">点我弹框</button>
</body>
<head>
    <title>Title</title>
    <base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
    <script type="text/javascript" src="jquery/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="layer/layer.js"></script>
    <script type="text/javascript">

        $(function(){
            /*id为 btn1*/
            $("#btn1").click(function () {
                $.ajax({
                    url: "send/array/one.html", //请求目标资源的地址
                    type: "post",           //请求方式
                    data: {
                        "array": [5, 8, 12]
                    },                        //要发送的请求参数
                    dataType: "text",        //如何对待服务器端返回的数据
                    success : function (response) {
                        alert(response);
                    },
                    error: function (response) {
                        alert(response);
                    }
                });
            });

            /*id为 btn2*/
            $("#btn2").click(function () {
                $.ajax({
                    url: "send/array/two.html", //请求目标资源的地址
                    type: "post",           //请求方式
                    data: {
                        "array[0]": 1,
                        "array[1]": 4,
                        "array[2]": 3
                    },                          //要发送的请求参数
                    dataType: "text",        //如何对待服务器端返回的数据
                    success: function (response) {
                        alert(response);
                    },
                    error: function (response) {
                        alert(response);
                    }
                });
            });

            /*id为 btn3*/
            $("#btn3").click(function () {
                var array = [1,2,3];
                //  将json数组转换成json字符串
                var requestBody = JSON.stringify(array);

                $.ajax({
                    url: "send/array/three.html",
                    type: "post",
                    contentType: "application/json;charset=UTF-8",
                    data: requestBody,
                    dataType: "text",
                    success: function (response) {
                        alert(response);
                    },
                    error: function (response) {
                        alert(response);
                    }
                })
            });

            /*id为 btn4*/
            $("#btn4").click(function () {
                //准备数据
                var student = {
                    "stuId": 5,
                    "stuName": "tom",
                    "address": {
                        "province": "江西",
                        "city": "南昌",
                        "street": "广兰大道"
                    },
                    subjectList: [
                        {
                            subjectName : "Java SE",
                            subjectScore : 100
                        },
                        {
                            subjectName : "SSM",
                            subjectScore : 98
                        }
                    ],
                    "map": {
                        "k1":"v1",
                        "k2":"v2",
                        "k3":"v3"
                    }
                };
                var requestBody = JSON.stringify(student);

                $.ajax({
                    url: "send/compose/object.json",
                    type: "post",
                    contentType: "application/json;charset=UTF-8",
                    data: requestBody,
                    dataType: "json",
                    success: function (response) {
                        alert("成功了");
                        alert(response);
                        console.log(response);
                    },
                    error: function (response) {
                        alert("出错了!")
                    }
                })
            });

            /*id为 btn5*/
            $("#btn5").click(function () {
                layer.msg("Layer的弹框");
                layer.msg("这里是 layer 弹出的消息！");
            });

        });

    </script>
</head>
</html>
