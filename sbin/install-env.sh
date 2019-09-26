echo 'install deps'
yum install gcc
yum install zlib zlib-devel bzip2-devel openssl-devel ncurses-devel sqlite-devel readline-devel tk-devel gdbm-devel db4-devel libpcap-devel xz-devel
yum install sqlite-devel

my_path=$(cd `dirname $0`;pwd)

py_package="Python-3.6.9"

cd $my_path/lib

if [ ! -d "$my_path/lib/$py_package" ]; then
	tar -zxvf ${py_package}.tgz
fi

cd $my_path/lib/$py_package

echo 'install py36'

./configure --prefix=$my_path/lib/python
make
make install

echo 'install py36 completed!'

rm -rf $my_path/lib/$py_package

echo 'removed py36 source release package'

#echo 'install py dependencies'

#$my_path/lib/python/bin/pip3 install incremental==17.5.0
#
#cd $my_path/lib
#tar -xvf Twisted-17.5.0.tar
#cd $my_path/lib/Twisted-17.5.0
#$my_path/lib/python/bin/python3.6 setup.py install
#
#cd $my_path
#rm -rf ./lib/Twisted-17.5.0
#
#$my_path/lib/python/bin/pip3 install -e .

echo 'install py dependencies completed!'


