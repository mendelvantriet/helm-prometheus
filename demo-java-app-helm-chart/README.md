# helm-java-app

## Prepare cluster and docker images

```
kind create cluster
kind load docker-image java-app
```

## Install helm chart

```
helm dependency update
helm install java-app .
kubectl get po
```

## Access web UI

    kubectl port-forward service/java-app 8080:8080

Go to `http://localhost:8080`.

## Stop

```
helm delete java-app
kind delete cluster
```

