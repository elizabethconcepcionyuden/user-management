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
   http://localhost:8080/api/swagger-ui/index.html#/

3. Para probar el endpoint POST, usa el siguiente JSON:
**Request - Escenario Satisfactorio**
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
   **Response - Exitoso Cod. 200**
   ```json
   {
   "id": "8dc1f35c-f565-4046-bccf-98e087f054d3",
   "lastLogin": "2025-05-30T03:59:20.903+00:00",
   "created": "2025-05-30T03:59:20.903+00:00",
   "modified": "2025-05-30T03:59:20.903+00:00",
   "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJlbGl6YWJldGhAZ21haWwuY29tIiwiaWF0IjoxNzQ4NTc3NTYwLCJleHAiOjE3NDg2NjM5NjB9.t1AB6O8EsTxhnH1s_Kxg2ws0f2J-rNbfYgWWa7AGmXA",
   "isActive": true
   }
  ```

## Para construirlo y correr con Docker
```bash
docker build -t user-management .
docker run -p 8080:8080 user-management
```


## Diagrama de la solución
![img.png](img.png)

## Pruebas Unitarias
-estan ubicadas en la carpeta `src/test/java`
- Ejecuta con:
```bash
./gradlew test