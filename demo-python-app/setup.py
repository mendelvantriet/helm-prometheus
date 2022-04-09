from setuptools import setup, find_packages


with open('README.md', 'r') as f:
    readme = f.read()

setup(
    name='demo-python-app',
    version='0.1',
    description='',
    long_description=readme,
    python_requires=">=3.7.*",
    packages=find_packages(where='src'),
    package_dir={"": "src"},
)
