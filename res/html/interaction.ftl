<html>
<header>
    <link rel="stylesheet" type="text/css" href="master.css">
    <style>
        .title {
            position: absolute;
            left: 10vw;
            top: 10vh;
            font-size: 100px;
        }

        .left_box {
            border: 5px black solid;
            border-radius: 8px;
            display: inline-block;
            position: absolute;
            margin: 2vw;
            top: 25vh;
            left: 10vw;
            width: 32vw;
            height: 60vh;
            vertical-align: top;
        }

        .right_box {
            border: 5px black solid;
            border-radius: 5px;
            display: inline-block;
            position: absolute;
            margin: 2vw;
            top: 25vh;
            right: 10vw;
            width: 32vw;
            height: 60vh;
            vertical-align: top;
        }

        .left_arrow {
            position: absolute;
            left: 47.7vw;
            top: 35vh;
            width: 5vw;
        }

        .right_arrow {
            position: absolute;
            right: 47.7vw;
            bottom: 23vh;
            width: 5vw;
            -webkit-transform: rotate(180deg);
            -moz-transform: rotate(180deg);
            -o-transform: rotate(180deg);
            -ms-transform: rotate(180deg);
            transform: rotate(180deg);
        }

        .content_title {
            margin: 3vh;
            text-align: center;
            font-size: 50px;
        }

        .content_content {
            margin: 2vh;
            font-size: 28px;
        }
    </style>
</header>
<body>
    <div class="title">${title}</div>
    <div class="left_box">
        <div class="content_title">${left_title}</div>
        <div class="content_content">${left_content}</div>
    </div>
    <div class="right_box">
        <div class="content_title">${right_title}</div>
        <div class="content_content">${right_content}</div>
    </div>
    <img class="left_arrow" src="right_arrow.svg">
    <img class="right_arrow" src="right_arrow.svg">
</body>
</html>