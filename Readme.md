# Organización del proyecto
La organización del proyecto está compuesta por las siguientes carpetas:
- docs: aquí se alojan todas las fotos o documentos de interés que necesitemos.
- src:
  - main:
    - conf:aquí se alojan todo tipo de configuraciones relacionadas con la seguridad,login,register....
    - controller:aquí se alojan todo tipo de controladores con el que manejamos su crud completo de nuestras clases modelo
    - model: nuestras clases entidad y las que le dan sentido al proyecto
    - repo: se alojan todas las interfaces necesarias 
    - service: aquí pondremos si fuera necesario los servicios de nuestras clases modelo
    - AppgeslawApplication.java: Es el archivo prtincipal de nuestro proyecto, sin él,no ejecutaría
  - resources: se encuentra el codigo de basicamente todo el frontend que uso:
    - static: aquí se encuentra todas las imagenes,etc.
    - application.properties: se encuentran las contraseñas necesarias para que se conecte con la base de datos,no se debería de subir a git por motivos obvios.
    - import.sql: se encuentra todos los insert si queremos añadir algun dato en alguna tabla directamente en la base de datos.
    - templates: aquí se encuentran todas las plantillas.
      - facturas:en el encontramos los archivos:
        - facturas.html: muestra todas las facturas.
        - add.hml: muestra el formulario para añadir facturas.
        - edit.html: muestra el formulario para editar facturas.
      - fragmentos:
        - general.html:
      - obligadocumplimientos:
      - usuarios:en el encontramos los archivos:
        - usuarios.html: muestra todos los usuarios,si tienes los requisitos suficientes para verlos(Admin).
        - add.html: muestra el formulario para añadir un usuario,si tienes los requisitos suficientes para verlos(Admin).
        - edit.html: muestra el formulario para editar un usuario,si tienes los requisitos suficientes para verlos(Admin).


## Ejecución del proyecto
Este proyecto está creado en spring,y como podemos observar uso un contenedor para crear la base de datos en mysql esto es gracias a las librerias que existen en spring,con ellas podemos crear nuestras clases modelo y una vez lancemos el programa de spring y con nuestro contenedor docker andando podremos ver como se crea automaticamente la base de datos a partir de nuestra base de datos. 
![Esquema de la base de datos](docs\image.png)



## Usuarios
Se encuentra en la carpeta templates/usuarios y podemos encontrar el archivo add y edit,no hace el borrado

## Facturas
No hace el borrado y hay que implementarle la lógica de poder añadir un fichero y únicamente sea pdf

## Obligado Cumplimiento
No hace el borrado y hay que implementarle la lógica de poder añadir un fichero y únicamente sea pdf

