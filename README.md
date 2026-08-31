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

val mercatorX = lon1.toMercatorX()
val mercatorY = lat1.toMercatorY()

val lon2 = mercatorX.toLongitude()
val lat2 = mercatorY.toLatitude()
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

The default build installs the Scala `2.12` version:

```shell
mvn clean install
```

For any other Scala version, name the matching profile:

```shell
mvn -P scala-2.11 clean install
mvn -P scala-2.13 clean install
```

`scala-2.11` and `scala-2.12` target Java 8; **`scala-2.13` targets Java 17**, because that
is the floor for the Spark 4.0 projects that consume it. Spark 4.0 is Scala 2.13 only, so a
Spark 4.0 consumer needs the `scala-2.13` artifact — Maven Central carries none of these, so
install locally first.

`scala-2.10` is commented out in `pom.xml` and has no command above. Naming a profile that
does not exist is only a warning to Maven, which then quietly builds the 2.12 default.

## Usage in pom.xml

The Scala compact version is part of the artifact version:

```xml
<dependency>
    <groupId>com.esri</groupId>
    <artifactId>webmercator</artifactId>
    <version>1.15-${scala.compact}</version>
</dependency>
```
