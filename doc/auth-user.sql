drop user IF EXISTS 'auth'@'%' ; -- 删除auth用户

CREATE USER 'auth'@'%' IDENTIFIED BY 'auth'; -- 账号auth，密码auth, 默认所有情况都能访问

SELECT User,HOST FROM mysql.`user` WHERE User = 'auth';

grant all privileges on `qx-test`.sys_oauth_client_details to 'auth'@'%'; -- 授予auth用户访问sys_oauth_client_details表所有权限

flush privileges; -- 刷新数据库权限
