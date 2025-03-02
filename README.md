# **CLOUD Calculatrice**

## **Description**
Calculatrice simple avec les opérations suivantes :
- Addition
- Soustraction
- Multiplication
- Division
- Puissance
- Racine carrée

---

## **Installation**
### **Prérequis**
- Java 17
- Docker
- Minikube https://minikube.sigs.k8s.io/docs/start/?arch=%2Fmacos%2Fx86-64%2Fstable%2Fbinary+download
- Istio https://istio.io/latest/docs/setup/getting-started/

---

## **Déploiement avec Kubernetes**
### **Démarrer Minikube**
```bash
minikube start --driver=docker      
```
### **Activer Istio**
```bash
istioctl install --set profile=demo -y
kubectl label namespace default istio-injection=enabled
```

### **Déployer les services**
```bash
kubectl apply -f calculatrice-service/deployment-backend.yml
kubectl apply -f calculatrice-service/service-backend.yml
kubectl apply -f calculatrice-front/deployment-frontend.yml
kubectl apply -f calculatrice-front/service-frontend.yml
kubectl apply -f kubernetes/gateway.yml
kubectl apply -f kubernetes/mysql-deployment.yml
kubectl apply -f kubernetes/mysql-service.yml
```

### **Vérifier les pods**
```bash
kubectl get pods,services
```
### **Récupérer l'IP du frontend**
```bash
minikube service calculatrice-front --url
```

---

## **Lancer avec Docker**
```bash
docker pull dlgart/calculatrice-service
docker pull dlgart/calculatrice-front

docker run -d -p 8080:8080 dlgart/calculatrice-service
docker run -d -p 8081:8080 dlgart/calculatrice-front
```

---
---

### **Lancer en Local**
**🔹 Backend :**
```bash
cd calculatrice-service
mvn spring-boot:run
```
**🔹 Frontend :**
Dans src/components/Calculatrice.vue, modifier la variable gatewayURL en "http://localhost:8080"
et lancer :
```bash
cd calculatrice-front
npm install
npm run serve
```
### **Accéder à l'application**
Ouvrir le navigateur et accéder à l'URL suivante : [http://localhost:8080/](http://localhost:8081/)

---
 


