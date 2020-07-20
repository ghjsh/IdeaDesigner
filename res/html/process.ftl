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
            width: 50vw;
            text-align: center;
        }
        
        .block {
            display: inline-block;
            width: 48vw;
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
    <div class="title main">${title}</div>
    <div class="content">
        <#list contents as content_title, content_content>
        <div class="block box">
                <div class="content_title main">${content_title}</div>
                <div class="content_content text">${content_content}</div>
        </div>
        <#sep>
        <svg class="arrow" version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 512 512" style="enable-background:new 0 0 512 512;" xml:space="preserve">
		<path d="M506.157,132.386c-7.803-7.819-20.465-7.831-28.285-0.029l-207.73,207.299c-7.799,7.798-20.486,7.797-28.299-0.015
			L34.128,132.357c-7.819-7.803-20.481-7.79-28.285,0.029c-7.802,7.819-7.789,20.482,0.029,28.284l207.701,207.27
			c11.701,11.699,27.066,17.547,42.433,17.547c15.358,0,30.719-5.846,42.405-17.533L506.128,160.67
			C513.946,152.868,513.959,140.205,506.157,132.386z"/>
        </svg>
        </#list>
    </div>
</body>
</html>