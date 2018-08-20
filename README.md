# springboot-jms-activemq-example

Belajar Java Messaging dengan Apache ActiveMQ.

- Queue
- Publisher / Subscriber
- Send / Response

JMS atau Java Message Service, biasanya digunakan untuk mengirimkan pesan atau message minimal 2 atau lebih aplikasi. JMS berbeda dengan email.

## Istilah JMS

- Provider, yaitu _Message Oriented Midleware_ atau aplikasi yang bertindak sebagai broker salah satu contohnya yaitu Apache ActiveMQ, RabitMQ, Hive MQTT, IBM MQ, JBoss Messaging dan lain-lain masih banyak lagi.
- Client, yaitu aplikasi yang bertindak sebagai pengirim atau penerima pesan.
- Producer / Publisher, yaitu aplikasi client atau JMS Client yang bertindak sebagai pengirim.
- Consumer / Subscriber, yaitu aplikasi client atau JMS Client yang bertindak sebagai penerima.
- Message, yaitu message atau data.
- queue, yaitu message yang diterima oleh client **diantrikan** dan dikirim satu-per-satu.
- topic, yaitu message yang diterima oleh client **disebarkan** ke setiap client yang terkonek.

## Required

- Java 8
- Maven
- ActiveMQ ([downloads disini](http://activemq.apache.org/download.html))

**run activemq service**

```bash
path-to-activemq/bin/activemq start
```

**stop activemq service** 

```bash
path-to-activemq/bin/activemq stop
```

Untuk mengakases halaman admin activemq : [http://localhost:8161](http://localhost:8161/admin/) dengan user default yaitu `admin` dan passwordnya `admin`.


## Message Queue

Message queue, dilewatkan melalui HTTP. ada beberapa protocol standar untuk menggunakan JMS yaitu 

- AMQP (Advanced Message Queuing Protocol), 
- STOMP (Streaming Text Oriented Messaging Protocol), dan 
- MQTT. 

## Modules

| service                       | port              | ref module                    | keterangan                            |
| :---                          | :---              | :---                          | :---                                  |
| queue-example                 | 8080              | -                             | point to point, as send and recived   |
| topic-example                 | 9090 s/d 9999     | -                             | topic, as publisher and subcriber     |
| request-reply-server-example  | 10000             | request-reply-client-example  | point to point as send                |
| request-reply-client-example  | 10001             | request-reply-server-example  | point to ponit as recived             |

## Referensi

- https://en.wikipedia.org/wiki/Java_Message_Service
- https://en.wikipedia.org/wiki/Message_queue
- https://docs.oracle.com/javaee/7/api/javax/jms/package-summary.html
- https://en.wikipedia.org/wiki/Message-oriented_middleware
- https://en.wikipedia.org/wiki/Advanced_Message_Queuing_Protocol
- https://en.wikipedia.org/wiki/Streaming_Text_Oriented_Messaging_Protocol
- https://en.wikipedia.org/wiki/MQTT
- https://en.wikipedia.org/wiki/Apache_ActiveMQ