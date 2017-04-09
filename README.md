# WebMercator

Simple java class to convert between geo and web mercator coordinates.

Update Apr 2017: Added Scala Double implicits to enable the conversion to/from WebMercator values. For example:

```
import com.esri.webmercator._

val lon1 = -127.2
val lat1 = 45.6

val mercatorX = lon1 toMercatorX
val mercatorY = lat1 toMercatorY

val lon2 = mercatorX toLongitude
val lat2 = mercatorY toLatitude
```

## Build the Project

[SBT](http://www.scala-sbt.org/) is the preferred way to build this project.

```
sbt +publishM2
```
