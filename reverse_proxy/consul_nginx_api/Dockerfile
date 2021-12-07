# Dockerfile

FROM consul_nginx_base:latest

ENV PYTHONUNBUFFERED=1 LC_ALL=C.UTF-8 LANG=C.UTF-8 FLASK_APP=app.py
RUN mkdir /app
WORKDIR /app
RUN python3 -m pip install Flask requests -U
ADD . /app/

COPY flask.conf /etc/supervisor/conf.d/flask.conf
COPY register.py /bin/register
RUN chmod +x /bin/register