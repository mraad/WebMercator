package com.esri;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 */
public class WebMercatorTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public WebMercatorTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(WebMercatorTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testWebMercator() {
        assertEquals(12.345678, WebMercator.yToLatitude(WebMercator.latitudeToY(12.345678)), 0.0000001);
        assertEquals(12.345678, WebMercator.xToLongitude(WebMercator.longitudeToX(12.345678)), 0.0000001);
    }

    /**
     * A round trip passes even with a wrong radius - these do not.
     */
    public void testReferenceValues() {
        // A pure multiply, so bit-reproducible on any JVM.
        assertEquals(1374314.58845772, WebMercator.longitudeToX(12.345678), 0.0);
        // Transcendental, so allow a micron of vendor-specific slack.
        assertEquals(1385074.274746461, WebMercator.latitudeToY(12.345678), 0.000001);
        // The Web Mercator clip latitude maps to the square extent edge.
        assertEquals(20037508.342789274, WebMercator.latitudeToY(85.05112877980659), 0.000001);
    }

    public void testXToLongitudeWrap() {
        final double x = WebMercator.longitudeToX(190.0);
        assertEquals(-170.0, WebMercator.xToLongitude(x, false), 0.000000001);
        assertEquals(190.0, WebMercator.xToLongitude(x, true), 0.000000001);
    }
}
