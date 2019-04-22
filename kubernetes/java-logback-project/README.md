java-logback-project
===================== 

Como desplegar una aplicacion java en kubernetes engine
--------------------------------------------------------

 Asumiendo que el [cluster ya ha sido creado](https://github.com/DevBenHa/researches/blob/master/kubernetes/files/Como-crear-un-cluster-en-kubernetes-engine.pdf)
 
 Desde una terminal con acceso a nuestro cluster (y con kubectl ya instalado)
 
 ``` terminal
  git clone https://github.com/DevBenHa/researches.git
  cd researches/kubernetes/java-logback-project/
  kubectl create configmap nombre-configmap --from-file=config-files/
```
  
 Crear el archivo de despliegue con extención .yaml:

``` yaml
apiVersion: v1
kind: PersistentVolume
metadata:
  name: nombre-disco-persistente
spec:
  storageClassName: ""
  capacity:
    storage: 10G #tamaño del volumen
  accessModes:
    - ReadWriteMany
  gcePersistentDisk:
    pdName: pd-cluster #nombre del disco persistente alojado en GCP (google cloud)
    fsType: ext4
---
apiVersion: v1
kind: PersistentVolumeClaim
metadata:
  name: nombre-volumen-claim
spec:
  # It's necessary to specify "" as the storageClassName
  # so that the default storage class won't be used, see
  # https://kubernetes.io/docs/concepts/storage/persistent-volumes/#class-1
  storageClassName: ""
  volumeName: nombre-persistentVolume #en este caso "nombre-disco-persistente"
  accessModes:
    - ReadWriteMany
  resources:
    requests:
      storage: 10G #tamaño a utilizar a partir del persistentVolume
```

