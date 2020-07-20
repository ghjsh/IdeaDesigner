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
            right: 20vw;
            top: 30vh;
            font-size: 100px;
            text-align: right;
        }

        .subtitle {
            position: absolute;
            right: 20vw;
            top: 50vh;
            font-size: 40px;
            width: 50vw;
            text-align: right;
        }
    </style>
</header>
<body>
    <div class="title">${title}</div>
    <div class="subtitle">${subtitle}</div>
</body>
</html>