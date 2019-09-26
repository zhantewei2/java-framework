import sys


isWin=sys.platform.find("win")>=0
memory={
    "client1":(128,384),
}

env={
    "test":{
        # ip , account, password, package_dir,ssh port
        "client1":("192.168.1.160","root","123456","/home/cas-client",22),
    },
    "prod":{
        "client1":("192.168.1.160","root","123456","/home/cas-client",22),
    }
}

import os
from os import path
def find_file(dir,name):
    try:
        files=[i for i in os.listdir(dir) if path.isfile(path.join(dir,i))]
        file_name=next(i for i in files if i.find(name)>=0)
        if not file_name:return None
        return path.join(dir,file_name)
    except:
        return None

host_path=path.dirname(path.dirname(path.dirname(path.abspath(__file__))))

my_machine=True
targets=["client1"]
output_dir_name="dist"
lib_dir_name="lib"
jar_dir="target"

