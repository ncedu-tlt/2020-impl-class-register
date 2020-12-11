<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <title>Title</title>
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
    <script>
        let chatUnit = {
            init() {
                this.startbox = document.querySelector(".start"); //set value
                this.chatbox = document.querySelector(".chatbox");

                this.startBtm = this.startbox.querySelector("button");
                this.nameInput = this.startbox.querySelector("input");

                this.msgTextArea = this.chatbox.querySelector("textarea");
                this.chatMessageContainer = this.chatbox.querySelector(".messages");

                this.bindEvents();
            },

            bindEvents() {
                this.startBtm.addEventListener("click", e=>this.openSocket())
                this.msgTextArea.addEventListener("keyup", e=>{ // take out the button
                    if(e.ctrlKey && e.keyCode===13) { // Ctrl + Enter
                        e.preventDefault();
                        this.send();
                    }
                })

            },

            send() {
                this.sendMessage({
                    name:this.name,
                    text:this.msgTextArea.value
                });
            },

            onOpenSock() {

            },

            onMessage(msg) {
                let msgBlock = document.createElement("div");
                msgBlock.className = "msg";

                let fromBlock = document.createElement("div");
                fromBlock.className = "from";
                fromBlock.innerText = msg.name;

                let textBlock = document.createElement("div");
                textBlock.className = "text";
                textBlock.innerText = msg.text;

                msgBlock.appendChild(fromBlock);
                msgBlock.appendChild(textBlock);

                this.chatMessageContainer.appendChild(msgBlock);

            },

            onClose() {

            },

            sendMessage(msg) {
                this.onMessage({name:"I'm", text: msg.text});
                this.msgTextArea.value = "";
                this.ws.send(JSON.stringify(msg));
            },

            openSocket() {
                this.ws = new WebSocket("ws://localhost:8080/sock/chat");
                this.ws.onopen = () => this.onOpenSock();
                this.ws.onmessage = (e) => this.onMessage(JSON.parse(e.data));
                this.ws.onclose = () => this.onClose();

                this.name = this.nameInput.value;
                this.startbox.style.display = "none";
                this.chatbox.style.display = "block";
            }

        };
        window.addEventListener("load", e=>chatUnit.init());
    </script>

</head>
<body>
    <h1>ChatBox</h1>
    <div class="start">
        <input type="text" class="username" placeholder="Enter name...">
        <button id="start">start</button>
    </div>

    <div class="chatbox">
        <div class="messages">

        </div>
        <textarea class="msg">

        </textarea>
        <input type="button" value="Нажми меня" id="elem">
      </div>
</body>
</html>
