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
        - general.html: son los menús que he definido por defecto que he definido
        - plantilla.html: es el esquema que sigue nuestro frontend
      - obligadocumplimientos: donde se encuentran los siguientes archivos:
        - obligadocumplimientos.html: muestra todos los obligado cumplimientos
        - add.html: formulario de añadir
        - edit.html: formulario de editar
      - usuarios: en el encontramos los archivos:
        - usuarios.html: muestra todos los usuarios,si tienes los requisitos suficientes para verlos(Admin).
        - add.html: muestra el formulario para añadir un usuario,si tienes los requisitos suficientes para verlos(Admin).
        - edit.html: muestra el formulario para editar un usuario,si tienes los requisitos suficientes para verlos(Admin).
      - acerca.html: archivo html que no tiene utilidad pero como en el menú existe lo creado,es estético.
      - ayuda.html: al igual que acerca,es totalmente estético.
      - denegado.html: es un archivo el cual indica a un usuario sino tiene permisos pues lo redirigimos a la siguiente página.
      - error.html: en caso de que exista algún tipo de error en nuestra página lo redirigimos a está que resulta más cómodo para el cliente ver que hay un error y que tiene que contactar con soporte.
      - index.html: es la página a la que redirigimos por defecto una vez hecho el login.
      - login.html: es la página por defecto de nuestro login.
      - signup.html: es la página para hacer un registro.


## Ejecución del proyecto
Este proyecto está creado en spring,y como podemos observar uso un contenedor para crear la base de datos en mysql esto es gracias a las librerias que existen en spring,con ellas podemos crear nuestras clases modelo y una vez lancemos el programa de spring y con nuestro contenedor docker andando podremos ver como se crea automaticamente la base de datos a partir de nuestra base de datos. 
![Esquema de la base de datos](docs\image.png)



## Usuarios
Se encuentra en la carpeta templates/usuarios y podemos encontrar el archivo add y edit,no hace el borrado

## Facturas
No hace el borrado y hay que implementarle la lógica de poder añadir un fichero y únicamente sea pdf

## Obligado Cumplimiento
No hace el borrado y hay que implementarle la lógica de poder añadir un fichero y únicamente sea pdf

