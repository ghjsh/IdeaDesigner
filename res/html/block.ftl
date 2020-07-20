<html>
<header>
    <script src="jquery.js"></script>
    <script>
        $(function () {
            document.addEventListener('click', function (event) {
                window.location = (window.location.href.split('/').pop().split('.')[0] * 1 + 1) + ".html";
            })
        });
    </script>
    <link rel="stylesheet" type="text/css" href="master.css">
    <style>
        .title {
            position: absolute;
            left: 10vw;
            top: 10vh;
            font-size: 100px;
        }

        .content {
            position: absolute;
            left: 12vw;
            top: 25vh;
            width: 75vw;
        }
        
        .block {
            border-radius: 1vw;
            display: inline-block;
            margin: 2vw;
            width: 20vw;
            height: 25vh;
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
        </#list>
    </div>
</body>
</html>