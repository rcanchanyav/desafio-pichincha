# Getting Started
### Tipo de Cambio
Para realizar las pruebas de manera local se debe clonar del repositorio GitHub.

Utilizar una consola(ex. Git Bash) y pegar la sigte linea

-- git clone https://github.com/rcanchanyav/desafio-pichincha.git


Luego ejecutar por consola

```bash
-- mvn clean install
```

luego cuando termine  de manera exitosa ejecutar la siguente linea
```bash
-- mvn spring-boot:run
```
Una vez ejecutada la aplicacion procedemos a probar los servicios .

Se tienen 2 Servicios para la autenticacion del usuario y generacion del token
Nota: Ejeuctar en ese orden.

* Creacion de Usuarios (POST):

  URL: http://localhost:8080/auth/register

Body
```
{
    "firstname": "Ronald",
    "lastname": "Suarez",
    "username": "admin",
    "password": "@Dm1n",
    "country": "PE"
}
```

* Generacion del Token (GET):

  URL: http://localhost:8080/auth/login?username=admin&password=@Dm1n

Una vez ejecutada la aplicacion procedemos a probar los servicios .

Para el Reto tecncio se tienen 3 Servicios:

Nota: Utilizar el token generado para cada peticion.

* Calcular el tipo de Cambio (POST):

  URL: http://localhost:8080/api/tipo-cambio/calculate

Body
```
{
	"monto":"180",
	"monedaOrigen":"PEN",
	"monedaDestino":"USD"
}
```

* Listar los tipos de cambios (GET):

  URL: http://localhost:8080/api/tipo-cambio/all


* Actualizar el tipo de Cambio (POST):

  URL: http://localhost:8080/api/tipo-cambio/update/3.95
Body
```
{
	"monedaOrigen":"PEN",
	"monedaDestino":"USD"
}
```

Nota: Se adjunta una collection del postman([TipoCambio.postman_collection.json](TipoCambio.postman_collection.json))
) en la raiz del proyecto
donde se encuentra los servicios mencionados.

Para acceder a la consola de la Base datos de H2 es :

URL: http://localhost:8080/h2-console


