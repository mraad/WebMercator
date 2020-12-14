import math


class WebMercator(object):
    @staticmethod
    def lon_to_x(lon: float) -> float:
        # return lon * 6378137.0 * math.pi / 180.0
        return lon * 111319.490793274

    @staticmethod
    def lat_to_y(lat: float) -> float:
        sin = math.sin(lat * math.pi / 180.0)
        return 3189068.5 * math.log((1.0 + sin) / (1.0 - sin))