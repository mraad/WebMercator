package com.esri;

/**
 * Class to convert lat/lon values to WebMercator.
 * <p>
 * This is the single source of truth for the math - the Scala implicits in
 * {@code com.esri.webmercator} delegate here so both stay bit-identical.
 */
public final class WebMercator {
    public static final double DEGREES_PER_RADIANS = 180.0 / Math.PI;
    public static final double RADIANS_PER_DEGREES = Math.PI / 180.0;
    public static final double PI_OVER_2 = Math.PI / 2.0;
    public static final double RADIUS = 6378137.0;
    public static final double RADIUS_2 = RADIUS * 0.5;
    public static final double RAD_RAD = RADIANS_PER_DEGREES * RADIUS;

    /**
     * Convert geo lat to vertical distance in meters.
     *
     * @param latitude the latitude in decimal degrees.
     * @return the vertical distance in meters.
     */
    public static double latitudeToY(final double latitude) {
        final double sin = Math.sin(latitude * RADIANS_PER_DEGREES);
        return RADIUS_2 * Math.log((1.0 + sin) / (1.0 - sin));
    }

    /**
     * Convert geo lon to horizontal distance in meters.
     *
     * @param longitude the longitude in decimal degrees.
     * @return the horizontal distance in meters.
     */
    public static double longitudeToX(final double longitude) {
        return longitude * RAD_RAD;
    }

    /**
     * Convert horizontal distance in meters to longitude in decimal degrees.
     *
     * @param x the horizontal distance in meters.
     * @return the longitude in decimal degrees.
     */
    public static double xToLongitude(final double x) {
        return x / RADIUS * DEGREES_PER_RADIANS;
    }

    /**
     * Convert horizontal distance in meters to longitude in decimal degrees.
     *
     * @param x      the horizontal distance in meters.
     * @param linear if using continuous pan.
     * @return the longitude in decimal degrees.
     */
    public static double xToLongitude(
            final double x,
            final boolean linear) {
        final double rad = x / RADIUS;
        final double deg = rad * DEGREES_PER_RADIANS;
        if (linear) {
            return deg;
        }
        final double rotations = Math.floor((deg + 180.0) / 360.0);
        return deg - (rotations * 360.0);
    }

    /**
     * Convert vertical distance in meters to latitude in decimal degrees.
     *
     * @param y the vertical distance in meters.
     * @return the latitude in decimal degrees.
     */
    public static double yToLatitude(final double y) {
        final double rad = PI_OVER_2 - (2.0 * Math.atan(Math.exp(-y / RADIUS)));
        return rad * DEGREES_PER_RADIANS;
    }
}
