Setup
=====

Create database using the following command:

```
create database luna character set utf8;
```

and run application with datasource parameters:

```
-Dspring.datasource.url=jdbc:mysql://example.com:3306/luna?useUnicode=true&characterEncoding=utf8
-Dspring.datasource.driver-class-name=com.mysql.jdbc.Driver
-Dspring.datasource.username=my_username
-Dspring.datasource.password=my_password
```