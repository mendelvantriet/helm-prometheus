# helm-prometheus

## Prepare cluster and docker images

```
docker pull prom/alertmanager:v0.21.0
docker pull jimmidyson/configmap-reload:v0.5.0
docker pull prom/node-exporter:v1.1.2
docker pull prom/prometheus:v2.26.0
docker pull prom/pushgateway:v1.3.1
docker pull k8s.gcr.io/kube-state-metrics/kube-state-metrics:v2.0.0

kind create cluster
kind load docker-image prom/alertmanager:v0.21.0
kind load docker-image jimmidyson/configmap-reload:v0.5.0
kind load docker-image prom/node-exporter:v1.1.2
kind load docker-image prom/prometheus:v2.26.0
kind load docker-image prom/pushgateway:v1.3.1
kind load docker-image k8s.gcr.io/kube-state-metrics/kube-state-metrics:v2.0.0

# For Grafana
docker pull grafana/grafana:8.0.1

kind load docker-image grafana/grafana:8.0.1

```

## Install helm chart

```
helm dependency update
helm install prometheus .
kubectl get po
```

## Access web UI

    kubectl port-forward service/prometheus-server 9090:80
    kubectl port-forward service/prometheus-grafana 8080:80

Go to `http://localhost:8080`.

## Stop

```
helm delete prometheus
kind delete cluster
```

