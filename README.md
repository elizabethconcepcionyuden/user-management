// README.md
# User Management Api

## Descripción
Esta API permite registrar usuarios, generando un token de autenticación (UUID o JWT), persistiendo la información en memoria usando H2.

## Tecnologías
- Java 17
- Spring Boot 3
- Gradle
- H2 Database
- Swagger OpenAPI
- JWT
- Docker
- JUnit

## Cómo probar
1. Ejecuta localmente:
    ```bash
    ./gradlew bootRun
    ```

2. Accede a Swagger:
   http://localhost:8080/api/swagger-ui/index.html#/User%20API/create

3. Para probar el endpoint POST, usa el siguiente JSON:
    ```json
    {
      "name": "Elizabeth Concepcion",
      "email": "elizabeth@gmail.com",
      "password": "Pass0rd@123",
      "phones": [
        {
          "number": "12002154785",
          "cityCode": "1",
          "countryCode": "57"
        }
      ]
    }
    ```

## Para construirlo y correr con Docker
```bash
docker build -t user-management .
docker run -p 8080:8080 user-management
```

## Diagrama de la solución
Diagrama de la solucion [https://www.plantuml.com/](https://www.plantuml.com/).

## Pruebas Unitarias
-estan ubicadas en la carpeta `src/test/java`
- Ejecuta con:
```bash
./gradlew test