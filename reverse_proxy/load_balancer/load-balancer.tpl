# load-balancer.tpl
{% raw %}
upstream backend {
   least_conn;
   {{ range service "api|passing" }}
   server {{ .Address }}:{{ .Port }};{{ end }}
}
{% endraw %}
server {
   listen      5000;
   server_name localhost;

   location / {
      proxy_pass http://backend;
   }
}