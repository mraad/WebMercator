package com.esri;

/**
 */
public final class WebMercator
{
    public static final double DEGREES_PER_RADIANS = 180.0 / Math.PI;
    public static final double RADIANS_PER_DEGREES = Math.PI / 180.0;
    public static final double PI_OVER_2 = Math.PI / 2.0;
    public static final double RADIUS = 6378137.0;

    public static double latitudeToY(double latitude)
    {
        final double rad = latitude * RADIANS_PER_DEGREES;
        final double sin = Math.sin(rad);
        return RADIUS * 0.5 * Math.log((1.0 + sin) / (1.0 - sin));
    }

    public static double longitudeToX(double longitude)
    {
        return longitude * RADIANS_PER_DEGREES * RADIUS;
    }

    public static double xToLongitude(final double x)
    {
        return xToLongitude(x, true);
    }

    public static double xToLongitude(
            final double x,
            final boolean linear)
    {
        final double rad = x / RADIUS;
        final double deg = rad * DEGREES_PER_RADIANS;
        if (linear)
        {
            return deg;
        }
        final double rotations = Math.floor((deg + 180.0) / 360.0);
        return deg - (rotations * 360.0);
    }

    public static double yToLatitude(final double y)
    {
        final double rad = PI_OVER_2 - (2.0 * Math.atan(Math.exp(-1.0 * y / RADIUS)));
        return rad * DEGREES_PER_RADIANS;
    }
}
