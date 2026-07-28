package com.esri

package object webmercator {

  /**
   * Double implicits.
   *
   * The math lives in [[com.esri.WebMercator]] - these are allocation-free
   * (AnyVal) wrappers, so the Java and Scala APIs cannot drift apart.
   *
   * No @inline here: under mixed compilation scalac sees WebMercator as Java
   * source rather than bytecode, so it cannot verify the call and skips it.
   * The JIT inlines a one-line static delegate anyway.
   *
   * https://docs.scala-lang.org/overviews/core/value-classes.html
   *
   * @param d the Double instance.
   */
  implicit final class DoubleImplicits(val d: Double) extends AnyVal {

    /**
     * @return the horizontal mercator value in meters.
     */
    final def toMercatorX(): Double = WebMercator.longitudeToX(d)

    /**
     * @return the vertical mercator value in meters.
     */
    final def toMercatorY(): Double = WebMercator.latitudeToY(d)

    /**
     * @return the longitude value from mercator x.
     */
    final def toLongitude(): Double = WebMercator.xToLongitude(d)

    /**
     * @return the latitude value from mercator y.
     */
    final def toLatitude(): Double = WebMercator.yToLatitude(d)

  }

}
