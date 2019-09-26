from setting import (
    env,find_file,my_machine,isWin,
    output_dir_name as output_dir,
    host_path,
    targets
)


if not isWin:
    from pexpect import pxssh
else:
    pxssh=None

from os import path
import sys
import time
import subprocess

target=sys.argv[1] if len(sys.argv)>1 else None
_env=sys.argv[2] if len(sys.argv)>2 else None

if not target or not env:
    print("short of argv")
    sys.exit()


output_dir=path.join(host_path,output_dir)



def scp(file_path,ip,account,password,package_path,ssh_port):
    cmd=f'scp -P {ssh_port} {file_path} {account}@{ip}:{package_path}'
    subprocess.run(cmd,shell=True)

def launch(name,ip,account,password,package_path,ssh_port):
    sbin_path = path.join(package_path,"sbin").replace("\\","/")
    if not isWin:
        s= pxssh.pxssh()
        try:
            s.login(ip,username=account,password=password,port=ssh_port)
            def cmd(line):
                s.sendline(line)
                s.expect("\n")
                s.prompt()
                print(str(s.before,"utf8"))
            cmd(f"cd {sbin_path}; ./start.sh stop {name}")
            time.sleep(5)
            cmd(f"cd {sbin_path}; ./start.sh start {name}")
        except Exception as e:
            print(e)
            raise Exception
        finally:
            s and s.close()
    else:
        subprocess.run(f'ssh -p {ssh_port} root@{ip} "cd {sbin_path}; ./start.sh stop {name}"',shell=True)
        time.sleep(6)
        subprocess.run(f'ssh -p {ssh_port} root@{ip} "cd {sbin_path}; ./start.sh start {name}"', shell=True)

def publish(name):
    print(f" ----publish-----: {name}")
    file_path=find_file(output_dir,name)
    print(output_dir,name)
    if not file_path: return print("not found %s"%name)
    ip,account,password,package_path,ssh_port=env.get(_env).get(name)
    try:
        scp(file_path,ip,account,password,path.join(package_path,'dist'),ssh_port)
        # launch(name,ip,account,password,package_path,ssh_port)
    except:
        print("publish failure")

def run(name):
    if name in targets:
        publish(name)
    elif name == "all":
        for i in targets:
            publish(i)
    else:
        print(f"not found {name}")

for name in target.split(","):
    run(name)