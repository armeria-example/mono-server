# interface repository setting
[mono-interface link](https://github.com/armeria-example/mono-interface)

### add interface repository 
```
git submodule add https://github.com/armeria-example/mono-idl
```

### pull interface repository  
```
cd mono-interface
git pull origin main
./gradlew generateProto
```

# test

### basic webflux test
```
curl -XGET http://127.0.0.1:8081/api/v1/user
```

### grpc(armeria) webflux test
```
curl -XPOST -H 'content-type: application/json; charset=utf-8; protocol=gRPC' 'http://127.0.0.1:8081/mono.idl.v1.user.UserService/RegisterUser' -d '{
  "loginId": "test",
  "password": "test1"
}'
```

# info
- [idl](https://github.com/armeria-example/mono-idl)
- [server](https://github.com/armeria-example/mono-server)
- [client](https://github.com/armeria-example/mono-client)