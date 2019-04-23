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

```
Hasta aqui se ha creado una imagen de docker alojada localmente.

Para subirla a Google Container Registry, es necesario primero añadir un tag específico a nuestra imagen y posteriormente hacer un push a la nube.

```bash
docker tag [ID_Imagen] [HOSTNAME]/[PROJECT-ID]/[IMAGE]
docker push [HOSTNAME]/[PROJECT-ID]/[IMAGE]

```

* [HOSTNAME] corresponde a la región de GCP donde será alojada la imagen.
Existen 4 tipos de Hostname:
  - gcr.io (recomiendo este)
  - us.gcr.io
  - eu.gcr.io
  - asia.gcr.io

* [PROJECT-ID] corresponde al ID que GCP otorga al projecto de GCP.

* [IMAGE] corresponde al nombre, asignado por usted mismo, de la imagen para identificarla.



Referencia sobre  [como subir una imagen a Google Container Registry](https://cloud.google.com/container-registry/docs/pushing-and-pulling)

Como desplegar una aplicacion java, contenida en una imagen de docker, en kubernetes engine
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
        - image: gcr.io/project/name #imagen alojada en container registry
          name: nombre-container # nombre para el contenedor
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
            - key: nombrearchivo.extension #nombre del archivo dentro del configmap
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

Para chequear si el contenedor se desplegó de manera correcta, ejecutar el comando:

``` bash
kubectl get pods

```

Si el STATUS del POD indica alguna acción distinta de "Running"

Ejecutar:

``` bash
kubectl describe pod nombre-del-pod
kubectl logs nombre-del-pod

```

Para ver los logs que se generaron al generar el deploy de la aplicación.

--------------------------------------------------------------------------- 
Monitoreo
---------------
Para ver los logs del POD en tiempo real 
