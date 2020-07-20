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
            left: 15vw;
            top: 30vh;
            font-size: 40px;
            width: 70vw;
        }
    </style>
</header>

<body>
    <div class="title">${title}</div>
    <div class="content">
        <ul>
        <#list contents as content>
            <li>${content}</li>
        </#list>
        </ul>
    </div>
</body>

</html>