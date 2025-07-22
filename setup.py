import os
import re

from setuptools import find_packages, setup


# Function to read version from pom.xml
def get_version_from_pom():
    try:
        # Get the path to pom.xml (in the same directory as setup.py)
        pom_path = os.path.join(os.path.dirname(os.path.abspath(__file__)), 'pom.xml')

        # If we can't find it using ElementTree due to namespace issues, try regex
        with open(pom_path, 'r') as f:
            content = f.read()
            match = re.search(r'<this\.version>([^<]+)</this\.version>', content)
            if match:
                return match.group(1)

        # Default fallback version if all else fails
        return '1.13'
    except Exception as e:
        print(f"Warning: Could not read version from pom.xml: {e}")
        return '1.13'  # Default fallback version


where = os.path.join("src", "main", "python")
setup(
    name='webmercator',
    version=get_version_from_pom(),
    description='Convert lon/lat values to web mercator x/y meters.',
    author='Mansour Raad',
    author_email='mraad@esri.com',
    python_requires='>=3.6',
    packages=find_packages(where=where),
    package_dir={'': where}
)
