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
            width: 50vw;
            text-align: center;
        }
        
        .block {
            border-radius: 1vw;
            display: inline-block;
            width: 48vw;
            background-color: aquamarine;
            text-align: left;
            padding: 1vw;
        }
        
        .content_title {
            display: inline;
            margin-right: 1vw;
            font-size: 2.5vw;
        }

        .content_content {
            display: inline;
            font-size: 1.5vw;
        }

        .arrow {
            width: 3vw;
        }
    </style>
</header>
<body>
    <div class="title">${title}</div>
    <div class="content">
        <#list contents as content_title, content_content>
        <div class="block">
                <div class="content_title">${content_title}</div>
                <div class="content_content">${content_content}</div>
        </div>
        <#sep>
        <img class="arrow" src="down_arrow.svg">
        </#list>
    </div>
</body>
</html>