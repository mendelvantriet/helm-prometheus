# demo-python-app

## Virtual env
```sh
python3 -m venv venv
source ./venv/bin/activate
```

## Install
```sh
pip install wheel
pip install -r requirements.txt
pip install -e .

cp example.env .env
nano .env  # edit as required
```

## Run

```sh
set -a && source .env && set +a 
uvicorn main:app --reload
...
```

## Docker Build

```sh
docker build -t demo-python-app .
```
