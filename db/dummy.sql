# 계정
INSERT INTO tb_user(id, pwd, name) VALUES ('admin', SHA2('admin', 256), 'admin');

INSERT INTO tb_user(id, pwd, name) VALUES ('test1', SHA2('test1', 256), 'test1');
INSERT INTO tb_user(id, pwd, name) VALUES ('test2', SHA2('test2', 256), 'test2');
INSERT INTO tb_user(id, pwd, name) VALUES ('test3', SHA2('test3', 256), 'test3');