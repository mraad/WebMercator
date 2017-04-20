package com.esri

package object webmercator {

  /**
    * Double implicits.
    *
    * @param d the Double instance.
    */
  implicit class DoubleImplicits(d: Double) extends Serializable {

    /**
      * @return the horizontal mercator value in meters.
      */
    @inline implicit def toMercatorX() = {
      WebMercator.longitudeToX(d)
    }

    /**
      * @return the vertical mercator value in meters.
      */
    @inline implicit def toMercatorY() = {
      WebMercator.latitudeToY(d)
    }

    /**
      * @return the longitude value from mercator x.
      */
    @inline implicit def toLongitude() = {
      WebMercator.xToLongitude(d)
    }

    /**
      * @return the latitude value from mercator y.
      */
    @inline implicit def toLatitude() = {
      WebMercator.yToLatitude(d)
    }
  }

}
