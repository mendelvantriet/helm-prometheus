FROM python:3.8.13-slim-bullseye AS base
ARG DEBIAN_FRONTEND=noninteractive

ENV PYTHONDONTWRITEBYTECODE 1
ENV PYTHONUNBUFFERED 1

WORKDIR /opt/app

RUN apt-get update --fix-missing && \
    apt-get upgrade -y && \
    rm -rf /var/lib/apt/lists/*

FROM base AS builder

RUN python -m pip install --no-cache-dir -U pip wheel

COPY . /opt/app

RUN python -OO -m pip wheel --no-cache-dir --wheel-dir=/root/wheels -r /opt/app/requirements.txt && \
    python -OO -m pip wheel --no-cache-dir --wheel-dir=/root/wheels /opt/app/.

FROM base
COPY --from=builder /root/wheels /root/wheels

RUN python -m pip install --no-cache --no-index /root/wheels/*
RUN rm -rf /root/wheels

CMD ["main:app", "--reload"]
ENTRYPOINT ["uvicorn"]
