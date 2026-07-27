package com.esri

package object webmercator {

  /**
   * Double implicits.
   *
   * The math lives in [[com.esri.WebMercator]] - these are allocation-free
   * (AnyVal) wrappers, so the Java and Scala APIs cannot drift apart.
   *
   * https://docs.scala-lang.org/overviews/core/value-classes.html
   *
   * @param d the Double instance.
   */
  implicit final class DoubleImplicits(val d: Double) extends AnyVal {

    /**
     * @return the horizontal mercator value in meters.
     */
    @inline final def toMercatorX(): Double = WebMercator.longitudeToX(d)

    /**
     * @return the vertical mercator value in meters.
     */
    @inline final def toMercatorY(): Double = WebMercator.latitudeToY(d)

    /**
     * @return the longitude value from mercator x.
     */
    @inline final def toLongitude(): Double = WebMercator.xToLongitude(d)

    /**
     * @return the latitude value from mercator y.
     */
    @inline final def toLatitude(): Double = WebMercator.yToLatitude(d)

  }

}
