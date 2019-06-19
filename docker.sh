IMAGE="gametrack-db"
DB_NAME="GAMETRACK"
DB_DOCKER_INSTANCE_NAME="gametrack-db-instance"
ROOT_PW="test"

# build db for gametrack
sudo docker build -t $IMAGE .

# set up MySQL DB locally
docker container stop $DB_DOCKER_INSTANCE_NAME
docker rm $DB_DOCKER_INSTANCE_NAME
docker run \
  --name $DB_DOCKER_INSTANCE_NAME \
  -e MYSQL_DATABASE=$DB_NAME \
  -e MYSQL_ROOT_PASSWORD=$ROOT_PW \
  -p 3306:3306 \
  -d $IMAGE
