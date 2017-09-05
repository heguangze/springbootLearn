<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>Video.js | HTML5 Video Player</title>
    <link href="/static/css/video-js.min.css" rel="stylesheet">
    <script src="/static/js/video.min.js"></script>
</head>

<body>

<video id="example_video_1" class="video-js vjs-default-skin" controls preload="none" width="640" height="264"
       data-setup="{}">
    <#--<source src="http://vjs.zencdn.net/v/oceans.mp4" type='video/mp4' />-->
        <source src="rtmp://live.hkstv.hk.lxdns.com/live/hks" type="rtmp/flv">
</video>

</body>
</html>
