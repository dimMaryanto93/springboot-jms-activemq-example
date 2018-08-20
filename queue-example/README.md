# Queue JmsTemplate


Untuk mengakases halaman admin activemq : [http://localhost:8161](http://localhost:8161/admin/) dengan user default yaitu `admin` dan passwordnya `admin`.

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