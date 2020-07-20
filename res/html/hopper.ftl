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
            display: inline-block;
            margin-left: 1vw;
            margin-right: 1vw;
            width: 13vw;
            height: 30vh;
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

        .hopper {
            position: absolute;
            width: 40vw;
            right: 10vw;
            top: 38vh;
            fill-opacity: 0.5;
        }

        .result {
            position: absolute;
            right: 12vw;
            top: 70vh;
            width: 36vw;
            height: 25vh;
            vertical-align: top;
        }
    </style>
</header>
<body>
    <div class="title main">${title}</div>
    <svg class="hopper" version="1.1" id="레이어_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px"
	 y="0px" width="829.588px" height="372.441px" viewBox="0 0 829.588 372.441" enable-background="new 0 0 829.588 372.441"
	 xml:space="preserve">
<rect x="-727.559" y="-139.323" fill="#FFFFFF" stroke="#000000" width="555.294" height="596.471"/>
<path d="M362.848,332.399l104.325,39.38c1.165,0.44,2.289,0.662,3.342,0.662c1.444,0,2.671-0.424,3.547-1.229
	c0.921-0.847,1.407-2.065,1.407-3.528v-78.391c0-4.456,4.037-9.843,9.001-12.007l309.643-134.974
	c4.811-2.098,12.495-5.704,17.129-8.041c0.184-0.093,18.347-9.335,18.347-16.435V58.721C829.588,26.342,643.512,0,414.794,0
	S0,26.342,0,58.721v59.115c0,7.101,18.16,16.341,18.343,16.433c4.632,2.336,12.317,5.944,17.13,8.042l309.644,134.976
	c4.964,2.164,9.001,7.551,9.001,12.007v32.209C354.118,325.694,358.034,330.584,362.848,332.399z M8.912,58.722
	c0-30.098,181.72-54.496,405.881-54.496s405.881,24.398,405.881,54.496c0,30.097-181.72,54.495-405.881,54.495
	S8.912,88.818,8.912,58.722z"/>
</svg>

    <div class="content">
        <#list contents as content>
        <div class="block box">
            <div class="content_title main">${content.titleValue}</div>
            <div class="content_content text">${content.contentValue}</div>
        </div>
        </#list>
    </div>
    <div class="result box">
        <div class="content_title main">${result_title}</div>
        <div class="content_content text">${result_content}</div>
    </div>
</body>
</html>