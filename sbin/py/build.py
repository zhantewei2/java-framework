import subprocess
import sys
import os
from os import path
import shutil
import re
from setting import (
    output_dir_name,
    lib_dir_name,
    jar_dir,
    targets,
    isWin,
    host_path
)



target=sys.argv[1] if len(sys.argv)>1 else None
env=sys.argv[2] if len(sys.argv)>2 else None

if not target or not env:
    print("short of argv")
    sys.exit()



dirs=[i for i in os.listdir(host_path) if path.isdir(path.join(host_path,i))]

def package(name,output_dir_name,extension=""):
    try:
        output_dir=path.join(host_path,output_dir_name)
        findItem=next(i for i in dirs if i.find(name)>=0)
        item_path=path.join(host_path,findItem)
        subprocess.run(
            "cd {} {} mvn clean && mvn package -P{}".format(item_path,
                "&&" if isWin else ";"
                ,env),
            shell=True
        )
        target_path=path.join(item_path,jar_dir)
        target_files=[i for i in os.listdir(target_path) if path.isfile(path.join(target_path,i))]
        jar_name=next(i for i in target_files if re.search("%s.*%s\.jar$"%(name,extension),i))
        jar_path=path.join(target_path,jar_name)
        shutil.copyfile(jar_path,path.join(output_dir,jar_name))
        print("%s successfully"%jar_name)

    except Exception as e:
        print(e)
        print("package %s failure"%name)

if target=="all":
    for i in targets:
        package(i,output_dir_name)
elif target in targets:
    package(target,output_dir_name)
elif target=="common":
    package("common",lib_dir_name,"dependencies")
else:
    print("not found dir")
