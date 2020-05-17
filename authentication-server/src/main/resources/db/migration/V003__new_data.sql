create table user_keyphrase (
  id serial,
  username varchar(100),
  keyphrase varchar(1024),
  message varchar(1024),
  constraint pk_user_keyphrase primary key (id),
  constraint fk_username foreign key (username) references oauth_user (username),
  constraint pk_user_uniques unique (username)
)