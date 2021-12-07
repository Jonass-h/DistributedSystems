# Dockerfile
FROM consul_nginx_base:latest

# APT tasks
RUN apt-get update && apt-get install gnupg -y

# Install nginx
COPY nginx.list /etc/apt/sources.list.d/nginx.list
RUN apt-key adv --keyserver keyserver.ubuntu.com --recv-keys ABF5BD827BD9BF62
RUN apt-get install nginx -y

# Consul template
RUN wget -q https://releases.hashicorp.com/consul-template/0.19.5/consul-template_0.19.5_linux_amd64.zip -O consul-template.zip && \
    unzip consul-template.zip && mv consul-template /bin/consul-template && rm consul-template.zip
RUN mkdir -p /etc/consul-templates/
COPY load-balancer.tpl /etc/consul-templates/load-balancer.tpl

# Our application
RUN python3 -m pip install requests --no-cache-dir
RUN useradd nginx
COPY nginx.conf /etc/nginx/nginx.conf
COPY default.conf /etc/nginx/conf.d/default.conf

# Supervisor files
COPY consul-template.conf /etc/supervisor/conf.d/consul-template.conf
COPY supervisor-nginx.conf /etc/supervisor/conf.d/nginx.conf

COPY register.py /bin/register

# Apt cleanup
RUN apt-get clean && rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*