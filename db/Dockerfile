FROM btshen/mysql-instance

# Hopefully I'm getting this right.

RUN docker pull mysql

RUN docker run --name mysql-instance -e MYSQL_DATABASE=GAMETRACK -e MYSQL_ROOT_PASSWORD=test -p 3306:3306 -p 33060:33060 -d mysql:latest

# COPY setup.sh setup.sh
# COPY tables.sql tables.sql

# RUN setup.sh