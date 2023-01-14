Mac
1、上传文件到远程Linux服务器
scp /Mac/local/simple-1.0-SNAPSHOT.jar root@120.77.19.44:/Linux/local
2、下载远程Linux服务器资源到本地Mac
scp root@120.77.19.44:/Linux/local /Mac/local

Nginx
1、安装
 a、准备工作【安装PCRE库、zlib库和openssl库（rewrite模块和gzip模块ssl模块需要）】
    yum install pcre pcre-devel zlib zlib-devel openssl openssl-devel openssl-libs
 b、下载nginx源码包并解压
    wget http://nginx.org/download/nginx-1.20.2.tar.gz
    tar -zxvf nginx-1.20.2.tar.gz
 c、进入nginx目录编译&安装
    ./configure --prefix=/web/nginx --with-http_ssl_module
        --prefix=安装目录
        --with-http_ssl_module 启用ssl模块
2、基础命令
 进入sbin目录有nginx执行文件
 a、启动
    ./nginx -s start
 b、重启
    ./nginx -s reload
 c、停止
    ./nginx -s stop
3、代理配置
http {
    # 负载均衡多个服务
    upstream wzw_server {
        server	localhost:7001	weight=1;
        server	localhost:7002	weight=1;
    }
    # 服务端口
    server {
        listen       80;
        server_name  localhost;
        location / {
            # 代理服务地址
            proxy_pass http://wzw_server;
	        proxy_set_header Host $http_host;
        }
}

Git
1、提交github.com超时
 提交代码到github.com时经常性的超时
【fatal: unable to access 'https://github.com/w-zewen/simple.git/': Failed to connect to github.com port 443 after 75026 ms: Operation timed out】
 解决方案：
 a、运行命令：
 wzw@wzwdeMacBook-Pro ~ % git config --global --unset http.proxy
 b、再次提交就可以了


