```bash
docker run -d --name users-db --net mynet1 mongo:latest
docker run -d --name users-service \
  --net mynet1 \
  -e DB_HOST=users-db \
  -e DB_PORT=27017 \
  -p 8080:8080 \
  users-service:v1
```
