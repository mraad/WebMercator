package com.esri

package object webmercator {

  /**
   * Double implicits.
   *
   * https://docs.scala-lang.org/overviews/core/value-classes.html
   *
   * @param d the Double instance.
   */
  implicit class DoubleImplicits(val d: Double) extends AnyVal {

    /**
     * @return the horizontal mercator value in meters.
     */
    @inline implicit def toMercatorX(): Double = {
      WebMercator.longitudeToX(d)
    }

    /**
     * @return the vertical mercator value in meters.
     */
    @inline implicit def toMercatorY(): Double = {
      WebMercator.latitudeToY(d)
    }

    /**
     * @return the longitude value from mercator x.
     */
    @inline implicit def toLongitude(): Double = {
      WebMercator.xToLongitude(d)
    }

    /**
     * @return the latitude value from mercator y.
     */
    @inline implicit def toLatitude(): Double = {
      WebMercator.yToLatitude(d)
    }
  }

}
