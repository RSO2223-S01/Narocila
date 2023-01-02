# RSO: Orders microservice

## Build and run commands
```bash
mvn clean package
java -jar api/target/narocila-api-1.0.0-SNAPSHOT.jar
```
Available at: localhost:8080/v1/orders

## Docker commands
```bash
docker build -t naro .
```

```bash
docker network ls  
docker network rm rso
docker network create rso
docker run -d --name pg-orders -e POSTGRES_USER=dbuser -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=narocila -p 5432:5432 --network rso postgres
docker run -p 8080:8080 --network rso -e KUMULUZEE_DATASOURCES0_CONNECTIONURL=jdbc:postgresql://pg-orders:5432/narocila naro
```

## Consul
Available at: localhost:8500

Key: environments/dev/services/narocila-service/1.0.0/config/rest-properties/maintenance-mode
Key: environments/dev/services/narocila-service/1.0.0/config/rest-properties/broken

Value: true or false

## Kubernetes
```bash
kubectl apply -f narocila-deployment.yaml 
kubectl get services 
kubectl get deployments
kubectl get pods
kubectl logs narocila-deployment-6f59c5d96c-rjz46
kubectl delete pod narocila-deployment-6f59c5d96c-rjz46
kubectl delete deployment narocila-deployment
```
Secrets: https://kubernetes.io/docs/concepts/configuration/secret/

