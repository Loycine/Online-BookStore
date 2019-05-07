# Online-BookStore
An online bookstore demo in Spring boot.


## deployment steps

1. edit the file "application.yml" to replace your personal datasource.

```
app:
  datasource:
    url: jdbc:mysql://localhost:3306/bookstore
    username: root
    password: 123456
    driver-class-name: com.mysql.jdbc.Driver
    type: com.alibaba.druid.pool.DruidDataSource
```

2. create your database and tabels using sql/create.sql.
