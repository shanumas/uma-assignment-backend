# uma-assignment-backend

Download the image using the following docker command: docker pull rabbitmq
Create and start the docker container using the following: docker run -d --hostname ecabsrabbit --name rabbit-assignment -e RABBITMQ_DEFAULT_VHOST=/ -p 15672:15672
rabbitmq:3-management
After starting the rabbitMQ container, you can then access the rabbitMQ web interface here:
http://localhost:15672/
with credentials:
username: guest
password: guest



Start both the producer and consumer:

Producer runs on:  http://localhost:9090


Add Booking Queue: http://localhost:9090/add

Edit Booking Queue : http://localhost:9090/edit

Delete Booking Queue : http://localhost:9090/delete

Consumer runs on:  http://localhost:9090


Get all bookings: http://localhost:9091/bookings
