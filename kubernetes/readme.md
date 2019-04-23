# Documentación sobre todos los tópicos necesarios
 ## Arquitectura Kubernetes
*    [Explicación Kubernetes](https://jee-appy.blogspot.com/2018/08/understanding-kubernetes-architecture.html)
 ## Software necesario para trabajar (Hay que instalarlo)
* Cloud SDK
  -   Google SDK
      - [General SDK](https://cloud.google.com/sdk/docs/quickstarts)
      - [SDK para RedHat/CentOS](https://cloud.google.com/sdk/docs/quickstart-redhat-centos)
* Kubernetes engine - kubectl
  - [Como instalar kubectl](https://cloud.google.com/kubernetes-engine/docs/quickstart)

## Crear Imagenes de Docker
* Dockerfile
    - Cómo crear una imagen de docker 
      - [doc1](https://www.howtoforge.com/tutorial/how-to-create-docker-images-with-dockerfile/ )
      - [doc2](https://codefresh.io/docker-tutorial/build-docker-image-dockerfiles/ )
      - [doc3](https://www.adictosaltrabajo.com/2015/07/29/docker-for-dummies/#07) en español
* Push image a google cloud
    - [Como subir imagenes a container registry](https://cloud.google.com/container-registry/docs/pushing-and-pulling)

# Clusters
* Crear un cluster
    - Seleccionar el tipo de hardware para los nodos del cluster
* Cluster privado
    - [Configurar cluster privado](https://cloud.google.com/kubernetes-engine/docs/how-to/private-clusters#private_master)
* Usar discos persistentes 
    - [Disco persistente de GCE](https://cloud.google.com/kubernetes-engine/docs/tutorials/persistent-disk)
* Config Maps
    - [Documentacion kubernetes](https://kubernetes.io/docs/tasks/configure-pod-container/configure-pod-configmap/#create-a-configmap)
    - [Documentación Google](https://cloud.google.com/kubernetes-engine/docs/concepts/configmap)
* Secrets
    - [Documentacion kubernetes](https://kubernetes.io/docs/concepts/configuration/secret/)
    - [Documentación Google](https://cloud.google.com/kubernetes-engine/docs/concepts/secret)
* Ref
    - [Como crear un cluster desde la consola de Google](https://github.com/DevBenHa/researches/blob/master/kubernetes/files/Como-crear-un-cluster-en-kubernetes-engine.pdf)
# Config Maps
Ejemplo de archivo YML de configmap
  - [Deployment Template + ConfigMap ](https://github.com/DevBenHa/researches/blob/master/kubernetes/files/templates/Deploy-using-config-maps.yaml) 
# Archivos YAML
  - [YAML sintaxis PDF oficial](https://yaml.org/spec/1.2/spec.pdf)
  - [YAML sintaxis oficial](https://yaml.org/spec/1.2/spec.html)
  - [Yaml sintaxis segun wikipedia](https://en.wikipedia.org/wiki/YAML)
  - Claims
  - Discos y volúmenes persistentes
  - Deployments
  - Services
  - Pods
# Ejemplos de archivo YAML 
* POD
  - [Deployment + Montaje de un Volumen Persistente](https://drive.google.com/open?id=1CRJVpEGWddqC-lnR_5riWBgYhV_eQVR6)
* Volumen
  - [Volume Claim + Persistent Volume Claim](https://drive.google.com/open?id=11RTAlVfd6kWF0YAst8S526J17OrB1Anu)
* Servicio
  - https://drive.google.com/open?id=1TuaS8xt3nTsomaqmHvUs9BS7gfS1NGL4 
  - [Como exponer un Servicio desde GKE](https://github.com/DevBenHa/researches/blob/master/kubernetes/files/Como%20crear%20un%20servicio.pdf)


## Ejemplo Funcional
  https://drive.google.com/open?id=1-KnFDvPNdjOBdifw2YY2RrLDqdgsLW4k 

# Permisos necesarios para el usuario de google cloud
 * Kubernetes Engine
 * Compute Engine
 * Stackdriver 
 * Logging
 * Error Report
 * ...

# Monitoreo
 * Google Stackdriver
# Reporte de errores
 * Google Error reporter
# Ejemplos:
  * https://codelabs.developers.google.com/codelabs/cloud-springboot-kubernetes/#0 
