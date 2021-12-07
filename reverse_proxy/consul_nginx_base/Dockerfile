# Dockerfile
FROM ubuntu:18.04

# Same exposed ports than consul
EXPOSE 8301 8301/udp 8302 8302/udp 8500 8600 8600/udp 8300

# unzip and wget for consul installation, python3 for supervisord
RUN apt-get update && apt-get install unzip wget python3 python3-distutils -y

# Pip the PyPA way, setuptools and wheel (note the --no-cache-dir to prevent pollution)
RUN wget -q https://bootstrap.pypa.io/get-pip.py -O /tmp/get-pip.py && \
    python3 /tmp/get-pip.py pip setuptools wheel --no-cache-dir

# Supervisord from PyPI doesn't support Python 3, so I download the master branch from GitHub
RUN python3 -m pip install https://github.com/Supervisor/supervisor/archive/master.zip --no-cache-dir && \
    mkdir -p /var/log/supervisor /etc/supervisor/conf.d/

# Download consul and move it to the PATH
ENV CONSUL_URL https://releases.hashicorp.com/consul/1.2.2/consul_1.2.2_linux_amd64.zip
RUN wget -q $CONSUL_URL -O /tmp/consul.zip && unzip /tmp/consul.zip && mv /consul /bin/consul && \
    mkdir /etc/consul.d/

# Configuration for starting the consul process, for the one shot registering and for
# supervisord itself
COPY consul.conf /etc/supervisor/conf.d/consul.conf
COPY register.conf /etc/supervisor/conf.d/register.conf
COPY supervisord.conf /etc/supervisor/supervisord.conf
ENTRYPOINT ["supervisord", "-c", "/etc/supervisor/supervisord.conf"]

# Cleanup!
RUN  apt-get clean && rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*