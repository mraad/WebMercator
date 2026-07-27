import os
import re

from setuptools import find_packages, setup

here = os.path.dirname(os.path.abspath(__file__))

# Single source of truth for the version - fail loudly rather than publish a stale one.
with open(os.path.join(here, 'pom.xml')) as f:
    match = re.search(r'<this\.version>([^<]+)</this\.version>', f.read())
assert match, 'no <this.version> found in pom.xml'
version = match.group(1)

where = os.path.join("src", "main", "python")
setup(
    name='webmercator',
    version=version,
    description='Convert lon/lat values to web mercator x/y meters.',
    author='Mansour Raad',
    author_email='mraad@esri.com',
    python_requires='>=3.6',
    packages=find_packages(where=where),
    package_dir={'': where}
)
