# reactor-demo
spring boot reactive app demo 

## usage:
### add user
    curl -X POST http://localhost:8080/users -H "Content-Type: application/json" -d '{"name": "kamil"}'
### get user by id
    curl -X GET "http://localhost:8080/users?id=1"
