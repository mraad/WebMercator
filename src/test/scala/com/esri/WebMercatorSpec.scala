package com.esri

//import org.scalatest.flatspec.AnyFlatSpec
// import org.scalatest.matchers.should

import com.esri.webmercator._
import org.scalatest._
import flatspec._
import matchers._

class WebMercatorSpec extends AnyFlatSpec with should.Matchers {

  it should "test lon to x to lon" in {
    12.345.toMercatorX.toLongitude shouldBe 12.345 +- 0.0001
  }

  it should "test lat to y to lat" in {
    12.345.toMercatorY.toLatitude shouldBe 12.345 +- 0.0001
  }
}
