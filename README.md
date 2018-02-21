# WebMercator

Simple Java class to convert between geo and web mercator coordinates.

_Update 2018 Feb_: Updated Maven pom to compile and build Scala implicits.  In addition, the output jar has the compact Scala version as a classifier.

_Update 2017 Apr_: Added Scala Double implicits to enable the conversion to/from web mercator values. For example:

```scala
import com.esri.webmercator._

val lon1 = -127.2
val lat1 = 45.6

val mercatorX = lon1 toMercatorX
val mercatorY = lat1 toMercatorY

val lon2 = mercatorX toLongitude
val lat2 = mercatorY toLatitude
```

## Build the project using [Maven](https://maven.apache.org/)

The following will install the Scala `2.10` version:

```shell
mvn clean install
```

To install the Scala `2.11` version, specify the `scala-2.11` profile:

```shell
mvn -Pscala-2.11 clean install
```

## Usage in pom.xml

```xml
<dependency>
    <groupId>com.esri</groupId>
    <artifactId>webmercator</artifactId>
    <version>1.4</version>
    <classifier>${scala.compact}</classifier>
</dependency>
```

## Build the project using [SBT](http://www.scala-sbt.org/)

```shell
sbt clean +publishM2 +publishLocal
```
