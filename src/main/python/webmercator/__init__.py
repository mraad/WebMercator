import math

RADIUS = 6378137.0
HALF_RADIUS = RADIUS * 0.5
RADIANS_PER_DEGREES = math.pi / 180.0
RAD_RAD = RADIANS_PER_DEGREES * RADIUS


class WebMercator:
    @staticmethod
    def lon_to_x(lon: float) -> float:
        return lon * RAD_RAD

    @staticmethod
    def lat_to_y(lat: float) -> float:
        sin = math.sin(lat * RADIANS_PER_DEGREES)
        return HALF_RADIUS * math.log((1.0 + sin) / (1.0 - sin))

    @staticmethod
    def x_to_lon(x: float) -> float:
        return math.degrees(x / RADIUS)

    @staticmethod
    def y_to_lat(y: float) -> float:
        return math.degrees(math.pi * 0.5 - 2.0 * math.atan(math.exp(-y / RADIUS)))


if __name__ == '__main__':
    # Same reference values as WebMercatorTest.java - catches a drifted constant,
    # which a round trip alone does not.
    assert WebMercator.lon_to_x(12.345678) == 1374314.58845772
    assert abs(WebMercator.lat_to_y(12.345678) - 1385074.274746461) < 1e-6
    assert abs(WebMercator.lat_to_y(85.05112877980659) - 20037508.342789274) < 1e-6
    for lon in (-179.9, -12.345678, 0.0, 12.345678, 179.9):
        assert abs(WebMercator.x_to_lon(WebMercator.lon_to_x(lon)) - lon) < 1e-9
    for lat in (-85.0, -12.345678, 0.0, 12.345678, 85.0):
        assert abs(WebMercator.y_to_lat(WebMercator.lat_to_y(lat)) - lat) < 1e-9
    print('ok')
