<html>
<head>
    <title>test Ws mqtt.js</title>
</head>
<body>
<script src="/static/js/bmqtt.js"></script>
<script>
    var options={
        username:"lusterJs"
    };
    var client = mqtt.connect('ws://172.16.3.89:8083/mqtt',options);
    client.subscribe("demo");
    client.on("message", function(topic, payload) {
        console.log([topic, payload].join(": "));
//        client.end();//断开连接
    });

    client.publish("demo", "hello world!");
</script>
</body>
</html>
