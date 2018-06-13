CREATE TABLE db_player
(
    id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    uid long,
    account varchar(20) NOT NULL,
    password varchar(20),
    user_name varchar(50),
    head_icon varchar(2000),
    create_time datetime,
    last_edit_time datetime,
    weath json,
    task json
)engine = InnoDB default charset = utf8 comment = '玩家数据';