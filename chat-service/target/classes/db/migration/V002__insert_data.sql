-- INSERT INTO chat_user (username, email)
--     VALUES
--     ('dana', 'dana@yahoo.com'),
--     ('profesor1', 'profesor1@yahoo.com'),
--     ('profesor2', 'profesor2@yahoo.com'),
--     ('profesor3', 'profesor3@yahoo.com'),
--     ('profesor4', 'profesor4@yahoo.com');

INSERT INTO conversation (id, username1, username2)
    VALUES
    (1, 'dana', 'profesor1'),
    (2, 'dana', 'profesor2'),
    (3, 'profesor1', 'profesor2');

INSERT INTO chat_message (sender, receiver, content, conversation_id)
  VALUES
  ('dana', 'profesor1', 'Salut profesor1', 1),
  ('profesor1', 'dana', 'Salut Dana!', 1),
  ('dana', 'profesor1', 'Ce mai faceti?', 1),
  ('dana', 'profesor2', 'Astept sa ma sunati!', 2),
  ('profesor1', 'profesor2', 'Astept sa ma sunati!', 2);





