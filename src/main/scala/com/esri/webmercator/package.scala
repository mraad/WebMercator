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
    implicit def toMercatorX() = {
      WebMercator.longitudeToX(d)
    }

    /**
      * @return the vertical mercator value in meters.
      */
    implicit def toMercatorY() = {
      WebMercator.latitudeToY(d)
    }

    /**
      * @return the longitude value from mercator x.
      */
    implicit def toLongitude() = {
      WebMercator.xToLongitude(d)
    }

    /**
      * @return the latitude value from mercator y.
      */
    implicit def toLatitude() = {
      WebMercator.yToLatitude(d)
    }
  }

}
