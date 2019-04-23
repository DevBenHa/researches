java-logback-project
===================== 
Como crear una imagen de Docker y subirla al Container Registry
--------------------------------------------------------

Desde este proyecto (y teniendo instalado Docker en nuestro pc)

Nos paramos en el directorio donde está el archivo Dockerfile
Si ya tenemos [conigurado el software necesario](https://github.com/DevBenHa/researches/wiki/Documentación#software-necesario-para-trabajar-hay-que-instalarlo)

``` bash
cd kubernetes/java-logback-project/
docker build -t nombreImagen .
docker images
docker tag IDimagen gcr.io/nombre-projecto/nombreImagen
docker push gcr.io/nombre-projecto/nombreImagen

```

Como desplegar una aplicacion java en kubernetes engine
--------------------------------------------------------

 Asumiendo que el [cluster ya ha sido creado](https://github.com/DevBenHa/researches/blob/master/kubernetes/files/Como-crear-un-cluster-en-kubernetes-engine.pdf)
 
 Desde una terminal con acceso a nuestro cluster (y con kubectl ya instalado)
 
 ``` bash
  git clone https://github.com/DevBenHa/researches.git
  cd researches/kubernetes/java-logback-project/
  kubectl create configmap nombre-configmap --from-file=config-files/
```
 Con esto hemos creado el configmap el cual contiene todas las configuraciones necesarias para nuestro proyecto de ejemplo
 
 
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
Cabe destacar que se pueden montar más de un configmap y en distintas rutas de ser necesario.
Un configmap puede representar:
  - Un directorio con archivos de configuración
  - Un archivo de configuración individual
  
  [Referencia](https://kubernetes.io/docs/tasks/configure-pod-container/configure-pod-configmap/)
  
  Esto tambien aplica para el montaje de volúmenes persistentes.
```bash

kubectl create -f nombreDeploy.yaml
kubectl get pods

```
