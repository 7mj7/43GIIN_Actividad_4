# Actividad 4 - Automatización de Pruebas

Proyecto para la asignatura 43GIIN_10_A_2023-24_Mantenimiento y evolución del Software. 
Se trata de una gestión muy simple para una biblioteca y la realización de  pruebas unitarias con JUnit.

## Configuración de JUnit


Este proyecto usa JUnit para hacer pruebas unitarias. A continuación se muestra cómo configurar JUnit:

### Requisitos previos

- Java Development Kit (JDK).
- Maven.

### Configuración en el archivo `pom.xml`

Agrega la siguiente dependencia de JUnit al archivo `pom.xml` del proyecto:

```xml
<dependencies>
    <!-- Otras dependencias -->
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13.2</version> <!-- O la versión más reciente disponible -->
        <scope>test</scope>
    </dependency>
</dependencies>
