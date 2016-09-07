Setup
=====

Create database using the following command:

```
create database luna character set utf8;
```

Populate database
```
mvn -Dliquibase.url="jdbc:mysql://example.com:3306/luna?useUnicode=true&characterEncoding=utf8" \
-Dliquibase.driver=com.mysql.jdbc.Driver \
-Dliquibase.username=my_username \
-Dliquibase.password=my_password \
liquibase:update
```

Build app

```
mvn package
```

Run application with datasource parameters:

```
java -Dspring.datasource.url="jdbc:mysql://example.com:3306/luna?useUnicode=true&characterEncoding=utf8" \
-Dspring.datasource.driver-class-name=com.mysql.jdbc.Driver \
-Dspring.datasource.username=my_username \
-Dspring.datasource.password=my_password \
-jar luna-server/target/luna-server-<verison>.jar
```