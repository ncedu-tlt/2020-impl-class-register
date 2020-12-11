<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>ChatBox</h1>

    <style>
        .chatbox{
            display: none;
        }
        .messages{
            background-color: #369;
            width: 500px;
            padding: 20px;
        }
        .messages .msg{
            background-color: #fff;
            border-radius: 10px;
            margin-bottom: 10px;
            overflow: hidden;
        }
        .messages .msg .from{
            background-color: #339966;
            line-height: 20px;
            text-align: center;
            color: white;
        }
        .messages .msg .text{
            padding: 10px;
        }
        textarea.msg{
            width: 540px;
            padding: 10px;
            resize: none;
            border: none;
            box-shadow: 2px 2px 5px 0 inset;
        }
    </style>

    <div class="start">
        <input type="text" class="username" placeholder="Enter name...">
        <button id="start">start</button>
    </div>

    <div class="chatbox">
        <div class="messages">
            <div class="msg">
                <div class="from">vasia</div>
                <div class="text">Hello world</div>
            </div>
        </div>
        <textarea class="msg">

        </textarea>
      </div>
</body>
</html>
