# reactor-demo
spring boot reactive app demo 

## usage:
### add user
    curl -X POST http://localhost:8080/users -H "Content-Type: application/json" -d '{"firstName": "kamil", "lastName":"Nowak", "pesel":"12121212", "role": "ADMIN"}'
### get user by id
    curl -X GET "http://localhost:8080/users?id=1"
### update user
    curl -X PUT http://localhost:8080/users?pesel=12121212 -H "Content-Type: application/json" -H "Role: ADMIN" -d '{"firstName": "kamil", "lastName":"Nowicki", "pesel":"12121212", "role": "ADMIN"}'

