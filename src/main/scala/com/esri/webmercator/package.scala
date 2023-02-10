package com.esri

import org.apache.commons.math3.util.FastMath

package object webmercator {

  /**
   * Double implicits.
   *
   * https://docs.scala-lang.org/overviews/core/value-classes.html
   *
   * @param d the Double instance.
   */
  implicit final class DoubleImplicits(val d: Double) extends AnyVal {

    /**
     * @return the horizontal mercator value in meters.
     */
    @inline implicit final def toMercatorX(): Double = {
      // WebMercator.longitudeToX(d)
      d * 6378137.0 * FastMath.PI / 180.0
    }

    /**
     * @return the vertical mercator value in meters.
     */
    @inline implicit final def toMercatorY(): Double = {
      val sin = FastMath.sin(d * FastMath.PI / 180.0)
      3189068.5 * FastMath.log((1.0 + sin) / (1.0 - sin))
    }

    /**
     * @return the longitude value from mercator x.
     */
    @inline implicit final def toLongitude(): Double = {
      // WebMercator.xToLongitude(d)
      (d * 180.0) / (FastMath.PI * 6378137.0)
    }

    /**
     * @return the latitude value from mercator y.
     */
    @inline implicit final def toLatitude(): Double = {
      (FastMath.PI * 0.5 - 2.0 * FastMath.atan(FastMath.exp(d / -6378137.0))) * 180.0 / FastMath.PI
    }
  }

}
