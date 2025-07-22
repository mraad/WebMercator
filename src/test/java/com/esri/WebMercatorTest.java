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
}
