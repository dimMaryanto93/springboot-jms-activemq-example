# Queue JmsTemplate

run the application:

```bash
mvn clean spring-boot:run
```

send message:

```bash
curl -X POST \
  http://localhost:8080/message/send \
  -H 'Cache-Control: no-cache' \
  -H 'Content-Type: application/json' \
  -d ' {
	        "value": "message to send",
	        "data" : "addon message"
        }'
```

## Arsitektur application

![arsitketur queue](imgs/point-to-point-arsitektur.jpg)