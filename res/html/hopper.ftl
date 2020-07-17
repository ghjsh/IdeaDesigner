<html>
<header>
    <link rel="stylesheet" type="text/css" href="master.css">
    <style>
        .title {
            width: 30vw;
            position: absolute;
            left: 10vw;
            top: 10vh;
            font-size: 100px;
        }

        .content {
            position: absolute;
            right: 4vw;
            top: 10vh;
            width: 52vw;
            text-align: center;
        }
        
        .block {
            border-radius: 1vw;
            display: inline-block;
            margin-left: 1vw;
            margin-right: 1vw;
            width: 15vw;
            height: 30vh;
            vertical-align: top;
            background-color: aquamarine;
        }
        
        .content_title {
            margin: 2vh;
            text-align: center;
            font-size: 2vw;
        }

        .content_content {
            margin: 2vh;
            font-size: 1.5vw;
        }

        .hopper {
            position: absolute;
            width: 40vw;
            right: 10vw;
            top: 38vh;
        }

        .result {
            position: absolute;
            right: 12vw;
            top: 70vh;
            border-radius: 1vw;
            width: 36vw;
            height: 25vh;
            vertical-align: top;
            background-color: aquamarine;
        }
    </style>
</header>
<body>
    <div class="title">${title}</div>
    <img class="hopper" src="hopper.svg">
    <div class="content">
        <#list contents as content_title, content_content>
        <div class="block">
            <div class="content_title">${content_title}</div>
            <div class="content_content">${content_content}</div>
        </div>
        </#list>
    </div>
    <div class="result">
        <div class="content_title">${result_title}</div>
        <div class="content_content">${result_content}</div>
    </div>
</body>
</html>