create table if not exists user(
  id varchar(50) primary key,
  account varchar(50),
  password varchar(100),
  password_salt varchar(50),
  nick_name varchar(50),
  create_date datetime default current_timestamp,
  update_date timestamp on update current_timestamp
);

create table if not exists user_info(
  id varchar(50) primary key ,
  age mediumint,
  city varchar(20),
  update_date timestamp on update current_timestamp
)