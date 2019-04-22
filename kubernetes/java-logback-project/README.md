java-logback-project
===================== 

Como desplegar una aplicacion java en kubernetes engine
--------------------------------------------------------

 Asumiendo que el [cluster ya ha sido creado](https://github.com/DevBenHa/researches/blob/master/kubernetes/files/Como-crear-un-cluster-en-kubernetes-engine.pdf)
 
 Desde una terminal con acceso a nuestro cluster (y con kubectl ya instalado)
 
 ``` bash
  git clone https://github.com/DevBenHa/researches.git
  cd researches/kubernetes/java-logback-project/
  kubectl create configmap nombre-configmap --from-file=config-files/
```
 
 Crear el archivo de despliegue con extención .yaml:

``` yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: Deployment-name
  labels:
    app: tag-app
spec:
  replicas: 1
  selector:
    matchLabels:
      app: tag-app
  template:
    metadata:
      labels:
        editor: vscode
        app: tag-app
    spec:
      containers:
        - image: gcr.io/project/name #gcp container registry
          name: nombre-container
          ports:
            - containerPort: 8080
              name: nombre-al-puerto
          volumeMounts:
            - name: app-props #nombre del volumen 
              mountPath: /cluster-data/apps/account/properties
      volumes:
        - name: app-props
          configMap:
            name: nombre-configmap
            items:
            - key: nombrearchivo.extension
              path: nombrearchivo.extencion # cómo se verá el archivo en el directorio

```

