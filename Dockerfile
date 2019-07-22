# reference: https://medium.com/better-programming/customize-your-mysql-database-in-docker-723ffd59d8fb

FROM mysql:latest

ENV MYSQL_DATABASE GAMETRACK

# any sql scripts to populate the DB
COPY ./db/*.sql /docker-entrypoint-initdb.d/
