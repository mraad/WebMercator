# WebMercator

Simple Java class to convert between geo and web mercator coordinates. No runtime dependencies - the Scala implicits and
the Python module delegate to (or mirror) the same math as `com.esri.WebMercator`.

## Java

```java
double x = WebMercator.longitudeToX(-127.2);
double y = WebMercator.latitudeToY(45.6);

double lon = WebMercator.xToLongitude(x);
double lat = WebMercator.yToLatitude(y);
```

## Scala

```scala
import com.esri.webmercator._

val lon1 = -127.2
val lat1 = 45.6

val mercatorX = lon1 toMercatorX
val mercatorY = lat1 toMercatorY

val lon2 = mercatorX toLongitude
val lat2 = mercatorY toLatitude
```

## Python

```python
from webmercator import WebMercator

x = WebMercator.lon_to_x(-127.2)
y = WebMercator.lat_to_y(45.6)

lon = WebMercator.x_to_lon(x)
lat = WebMercator.y_to_lat(y)
```

## Build the project using [Maven](https://maven.apache.org/)

The following will install the Scala `2.12` version:

```shell
mvn clean install
```

To install the Scala `2.11` or `2.13` version, specify the matching profile:

```shell
mvn -Pscala-2.13 clean install
```

## Usage in pom.xml

The Scala compact version is part of the artifact version:

```xml
<dependency>
    <groupId>com.esri</groupId>
    <artifactId>webmercator</artifactId>
    <version>1.14-${scala.compact}</version>
</dependency>
```
