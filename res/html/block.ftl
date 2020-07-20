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
            display: inline-block;
            margin: 2vw;
            width: 20vw;
            height: 25vh;
            vertical-align: top;
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
    <div class="title main">${title}</div>
    <div class="content text">
        <#list contents as content>
        <div class="block box">
            <div class="content_title main">${content.titleValue}</div>
            <div class="content_content text">${content.contentValue}</div>
        </div>
        </#list>
    </div>
</body>
</html>