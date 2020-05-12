INSERT INTO chat_user (username, email)
    VALUES
    ('dana', 'dana@yahoo.com'),
    ('roxana', 'roxana@yahoo.com'),
    ('dima', 'dima@yahoo.com'),
    ('matei', 'matei@yahoo.com');

INSERT INTO conversation (id, username1, username2)
    VALUES
    (1, 'dana', 'roxana'),
    (2, 'dana', 'dima'),
    (3, 'dima', 'roxana');

INSERT INTO chat_message (sender, receiver, content, conversation_id)
VALUES
('dana', 'roxana', 'salut roxana', 1),
('roxana', 'dana', 'salut dana', 1),
('dana', 'roxana', 'ce mai faci?', 1),
('dana', 'dima', 'astept sa ma suni', 2);





