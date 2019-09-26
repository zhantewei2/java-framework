#!/usr/bin/env bash
#
#   auth :zhantewei
#
#
#
source ./config.sh
##
#
#
#
##
my_path=$(cd `dirname $0`;pwd)
echo $@
package_name=$@

if [ ! -n "$package_name" ];then
    echo "syntax::   ./start.sh \$PACKAGE_NAME"
    exit
fi


function packageInTargets(){
    package_exists="False"
    for i in ${targets[@]}; do
        if [ "$@" == "$i" ]; then
            package_exists="True"
        fi
    done

    if [ "$package_exists" == "False" ]; then
        echo "not found package"
        exit
    fi
}

packageInTargets $package_name

host_path=`dirname $my_path`
dist_path=$host_path/dist
dir=$(cd $dist_path; ls)


function lauch_package(){
    package_path=$@
    package_size=${targetSize["client1"]}
    arr=(`echo $package_size | tr ',' ' '`)
    nohup java -jar -Xms${arr[0]}M -Xms${arr[1]}M $package_path > /dev/null &
}
function stop_package(){
    echo 'stop'
}

for i in $dir; do
    file_path=$dist_path/$i
    if [ -f "$file_path" ]; then

        index=`expr match "$i" ".*$package_name"`

        if [ $index -gt 0 ];then
            echo "hello" $file_path
            lauch_package $file_path

        fi
    fi
#    if [ ! -f "$i" ]; then
#        echo $i
#    fi
done
