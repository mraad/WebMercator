import os
from setuptools import find_packages, setup

where = os.path.join("src", "main", "python")
setup(
    name='webmercator',
    version='1.5',
    description='Convert lon/lat values to web mercator x/y meters.',
    author='Mansour Raad',
    author_email='mraad@esri.com',
    python_requires='>=3.6',
    packages=find_packages(where=where),
    package_dir={'': where}
)