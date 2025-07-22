package com.esri

// import org.scalatest.flatspec.AnyFlatSpec
// import org.scalatest.matchers.should

import com.esri.webmercator._
import org.scalatest.flatspec._
import org.scalatest.matchers._

class WebMercatorSpec extends AnyFlatSpec with should.Matchers {

  it should "test lon to x to lon" in {
    12.345678.toMercatorX.toLongitude shouldBe 12.345678 +- 0.0000001
  }

  it should "test lat to y to lat" in {
    12.345678.toMercatorY.toLatitude shouldBe 12.345678 +- 0.0000001
  }

  it should "test lat to y to lat 2" in {
    // 89.99951147544733
    89.999511475.toMercatorY.toLatitude shouldBe 89.999511475 +- 1e-10
  }

  it should "test lat to y to lat 3" in {
    // 89.99951147544733
    -89.999511475.toMercatorY.toLatitude shouldBe -89.999511475 +- 1e-10
  }
}
