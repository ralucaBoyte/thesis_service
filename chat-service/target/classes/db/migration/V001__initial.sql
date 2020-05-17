create table chat_user (
  username varchar(100) not null,
  email varchar(100) not null,
  constraint pk_user primary key (username)
);

create table conversation (
  id serial,
  username1 varchar(100) not null,
  username2 varchar(100) not null,
  constraint pk_conversation primary key(id),
  constraint fk1_conversation foreign key (username1) references chat_user(username),
  constraint fk2_conversation foreign key (username2) references chat_user(username)
);

create table chat_message (
  id serial,
  sender varchar(100),
  receiver varchar(100),
  content TEXT,
  conversation_id serial,
  constraint pk_chat_message primary key (id),
  constraint fk1_user1 foreign key (sender) references chat_user(username),
  constraint fk1_user2 foreign key (receiver) references chat_user(username),
  constraint fk_chat_message_conversation foreign key (conversation_id) references conversation(id)
);

