# register.py
#! /usr/bin/env python3
import requests
import time

consul_register_endpoint = "http://localhost:8500/v1/agent/service/register"

template = {
   "name": "nginx",
   "tags": ["nginx"],
   "address": "",
   "port": 80,
   "checks": [
      {
         "http": "http://localhost:80",
         "interval": "5s"
      }
   ]
}

for retry in range(10):
   res = requests.put(consul_register_endpoint, json=template)
   print("Attempt num:", retry, "Response Status:", res.status_code)
   if res.status_code == 200:
      print("Registering successful!")
      break
   else:
      print(res.text)
   time.sleep(1)
else:
   print("Run out of retires. So something went wrong.")