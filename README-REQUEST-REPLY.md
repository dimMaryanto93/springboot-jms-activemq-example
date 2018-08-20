# Request / Reply Method

Run application

```bash
# install dependency
cd request-reply-messages-example && mvn clean install

## run client
cd request-reply-client-example && mvn clean spring-boot:run -Dserver.port=10000

## run server
cd request-reply-server-example && mvn clean spring-boot:run -Dserver.port=10001
```

Testing request:

```bash
curl -X POST \
  http://localhost:10000/message/send \
  -H 'Cache-Control: no-cache' \
  -H 'Content-Type: application/json' \
  -d '{
        "requestId": "105"
      }'
```