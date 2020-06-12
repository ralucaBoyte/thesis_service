INSERT INTO oauth_client_details (client_id, client_secret, web_server_redirect_uri, scope, access_token_validity, refresh_token_validity, resource_ids, authorized_grant_types, additional_information) VALUES
 ('mobile', '$2a$10$.nXilPpfyYleLrJFT1lAF.1FQss/UgLB4HHtlrroqRLCaX8ZafwEm', 'http://localhost:8080/code', 'READ,WRITE', '7200', '10000', null, 'authorization_code,password,refresh_token,implicit', '{}');

 INSERT INTO PERMISSION (NAME) VALUES
 ('create_profile'),
 ('read_profile'),
 ('update_profile'),
 ('delete_profile');

 INSERT INTO role (NAME) VALUES
		('PROFESSOR'),('STUDENT');

 INSERT INTO PERMISSION_ROLE (PERMISSION_ID, ROLE_ID) VALUES
     (1,1), /*create-> admin */
     (2,1), /* read admin */
     (3,1), /* update admin */
     (4,1), /* delete admin */
     (2,2),  /* read operator */
     (3,2);  /* update operator */

insert into oauth_user (id, username,password, email, enabled, account_non_expired, credentials_non_expired, account_non_locked) VALUES ('1', 'dana','$2a$04$8sSn7YKQT5nV8eN57QDTFORYZtB.V5VTT1lolHSwG1jB.7J2iKydK', 'dana@yahoo.com', '1', '1', '1', '1');
insert into  oauth_user (id, username,password, email, enabled, account_non_expired, credentials_non_expired, account_non_locked) VALUES ('2', 'roxana', '$2a$10$tUJSiu11slhhYj4Rv1X3/.KG4NmvWy.zyK6oeewkYIeGlxoFgUPn2','roxana@yahoo.com',  '1', '1', '1', '1');
insert into  oauth_user (id, username,password, email, enabled, account_non_expired, credentials_non_expired, account_non_locked) VALUES ('3', 'student1', '$2a$04$XPIgWrWdMCxkkUZgyODgyOagi.RubM81ihOJ2hioSPdohlErfMvzO','student1@yahoo.com',  '1', '1', '1', '1');
insert into  oauth_user (id, username,password, email, enabled, account_non_expired, credentials_non_expired, account_non_locked) VALUES ('4', 'student2', '$2a$04$API7oQKch0TAYcBEnzCpsuqqB2K0dmKLBSNO748jrzNxEhqDikdoW','student2@yahoo.com',  '1', '1', '1', '1');
insert into  oauth_user (id, username,password, email, enabled, account_non_expired, credentials_non_expired, account_non_locked) VALUES ('5', 'student3', '$2a$04$sDcwsdZhtkqsYryrLBclYu2hchEOxOdqRXAbDtawZoRR1qsvoC0KS','student3@yahoo.com',  '1', '1', '1', '1');
insert into  oauth_user (id, username,password, email, enabled, account_non_expired, credentials_non_expired, account_non_locked) VALUES ('6', 'student4', '$2a$04$s5t.O9iuY8JL3Acvi7lSs.v3aqPFqkKpPuR.mwqA0fpFxgWLMfx.O','student4@yahoo.com',  '1', '1', '1', '1');
insert into  oauth_user (id, username,password, email, enabled, account_non_expired, credentials_non_expired, account_non_locked) VALUES ('7', 'profesor1', '$2a$04$iJqhqdZQnVNIZskx43r8/.HY0uYsHB3HIkKm24LRWZpO1SQDLGKmG','profesor1@yahoo.com',  '1', '1', '1', '1');
insert into  oauth_user (id, username,password, email, enabled, account_non_expired, credentials_non_expired, account_non_locked) VALUES ('8', 'profesor2', '$2a$04$wEbbhPoOyOorKGzY5G0XQexh.SXPh105E8YvohkVwkCCrzvDttFbi','profesor2@yahoo.com',  '1', '1', '1', '1');
insert into  oauth_user (id, username,password, email, enabled, account_non_expired, credentials_non_expired, account_non_locked) VALUES ('9', 'profesor3', '$2a$04$ZlG.sAkHZN9yBX8UwSXdA.HF44CpYgLe7dmyQMfowS.ga8hZ7llRm','profesor3@yahoo.com',  '1', '1', '1', '1');
insert into  oauth_user (id, username,password, email, enabled, account_non_expired, credentials_non_expired, account_non_locked) VALUES ('10', 'profesor4', '$2a$04$ajF0YXyPDx880qbYY5g1u.YxcfufK1tTGZhl5lbMn7sJEz2pLAd/m','profesor4@yahoo.com',  '1', '1', '1', '1');
insert into  oauth_user (id, username,password, email, enabled, account_non_expired, credentials_non_expired, account_non_locked) VALUES ('11', 'student', '$2a$10$Qgfm6e874KVYrVbb/RGe9ezRUZDAQYWAzsl24Pe8YWuB5bfIrgoWS','student@yahoo.com',  '1', '1', '1', '1');

INSERT INTO ROLE_USER (ROLE_ID, USER_ID)
    VALUES
    (1, 1) /* dana-PROFESSOR */,
    (2, 2) /* roxana-STUDENT */ ,
    (2, 3),
    (2, 4),
    (2, 5),
    (2, 6),
    (1, 7),
    (1, 8),
    (1, 9),
    (1, 10),
    (2, 11);

insert into reviews (professor, student, feedback, review_grade) VALUES
('dana', 'student1', 'o profesoara exceptionala!', 9.3),
('dana', 'student2', 'Cel mai frumos curs!', 10),
('dana', 'student3', 'Cea mai dedicata!', 10),
('profesor1', 'student3', 'Un profesor dedicat!', 8.4);

