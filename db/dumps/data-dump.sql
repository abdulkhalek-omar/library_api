####################################### language #######################################
INSERT INTO libraryDB.language (id, iso_639_1)
VALUES (1, 'de');
INSERT INTO libraryDB.language (id, iso_639_1)
VALUES (2, 'ar');
####################################### publisher #######################################
INSERT INTO libraryDB.publisher (id, publisher_name)
VALUES (1, 'Amazon');
INSERT INTO libraryDB.publisher (id, publisher_name)
VALUES (2, 'Springer Verlag');
####################################### country #######################################
INSERT INTO libraryDB.country (id, country_name)
VALUES (1, 'Afghanistan');
INSERT INTO libraryDB.country (id, country_name)
VALUES (2, 'Albanie');
INSERT INTO libraryDB.country (id, country_name)
VALUES (3, 'Algérie');
INSERT INTO libraryDB.country (id, country_name)
VALUES (5, 'Andorre');
INSERT INTO libraryDB.country (id, country_name)
VALUES (6, 'Angola');
INSERT INTO libraryDB.country (id, country_name)
VALUES (7, 'Germany');
INSERT INTO libraryDB.country (id, country_name)
VALUES (4, 'Samoa Américaines');
####################################### category #######################################
INSERT INTO libraryDB.category (id, category_name)
VALUES (1, 'Krimis');
INSERT INTO libraryDB.category (id, category_name)
VALUES (2, 'Science Fiction');
INSERT INTO libraryDB.category (id, category_name)
VALUES (3, 'Fantasy');
INSERT INTO libraryDB.category (id, category_name)
VALUES (4, 'Spekulative Literatur');
INSERT INTO libraryDB.category (id, category_name)
VALUES (5, 'Mystery');
INSERT INTO libraryDB.category (id, category_name)
VALUES (6, 'Thriller & Spannung');
INSERT INTO libraryDB.category (id, category_name)
VALUES (7, 'Horror & Übernatürliches');
INSERT INTO libraryDB.category (id, category_name)
VALUES (10, 'Mythen & Legenden');
INSERT INTO libraryDB.category (id, category_name)
VALUES (11, 'Historische Romane');
INSERT INTO libraryDB.category (id, category_name)
VALUES (12, 'Familiensagas');
INSERT INTO libraryDB.category (id, category_name)
VALUES (13, 'Abenteuerromane');
INSERT INTO libraryDB.category (id, category_name)
VALUES (14, 'Liebesromane');
INSERT INTO libraryDB.category (id, category_name)
VALUES (15, 'Erotik');
INSERT INTO libraryDB.category (id, category_name)
VALUES (16, 'Lifestyle-Literatur');
INSERT INTO libraryDB.category (id, category_name)
VALUES (17, 'Familienleben');
INSERT INTO libraryDB.category (id, category_name)
VALUES (18, 'Sportromane');
INSERT INTO libraryDB.category (id, category_name)
VALUES (19, 'Humor & Satire');
INSERT INTO libraryDB.category (id, category_name)
VALUES (20, 'Comic & Cartoon');
INSERT INTO libraryDB.category (id, category_name)
VALUES (21, 'Musik');
INSERT INTO libraryDB.category (id, category_name)
VALUES (22, 'Religiöse & spirituelle Belletristik');
####################################### author #######################################
INSERT INTO libraryDB.author (id, birth_date, cv, first_name, last_name)
VALUES (1, '1964-03-12 17:05:09.000000',
        'Ferdinand Benedikt von Schirach ist ein deutscher Schriftsteller und Jurist. Bekannt wurde er auch als Strafverteidiger in den Mauerschützenprozessen.',
        'Ferdinand Benedikt', 'von Schirach');
INSERT INTO libraryDB.author (id, birth_date, cv, first_name, last_name)
VALUES (2, '1877-07-02 17:07:20.000000', 'war ein deutsch-schweizerischer Schriftsteller',
        'Dichter und Maler. Bekanntheit erlangte er mit Prosawerken wie Siddhartha', ' Der Steppenwolf');
####################################### user #######################################
INSERT INTO libraryDB.user (id, email, first_name, last_name, phone, user_role)
VALUES (1, 'user@example.com', 'fUser', 'Luser', '092145446820', 'user');
INSERT INTO libraryDB.user (id, email, first_name, last_name, phone, user_role)
VALUES (2, 'user2@example.com', 'fUser', 'Luser2', '092145446822', 'user');
INSERT INTO libraryDB.user (id, email, first_name, last_name, phone, user_role)
VALUES (3, 'admin@example.com', 'f_admin', 'l_admin', '092145446000', 'admin');
####################################### address #######################################
INSERT INTO libraryDB.address (id, address_line_1, address_line_2, city, postal_code, street, country_id)
VALUES (1, 'Frankfurt', null, 'Enkenbach', '67677 ', 'Mozartstr. 9', 7);
INSERT INTO libraryDB.address (id, address_line_1, address_line_2, city, postal_code, street, country_id)
VALUES (2, 'Berlin', null, 'Dieter Wellhausen', 'D-11179', 'Dieter Wellhausen', 7);
####################################### user_address #######################################
INSERT INTO libraryDB.user_address (user_id, address_id)
VALUES (1, 1);
INSERT INTO libraryDB.user_address (user_id, address_id)
VALUES (3, 2);
####################################### book #######################################
INSERT INTO libraryDB.book (id, description, isbn, number_of_page, publish_at, title, author_id, category_id,
                            language_id, publisher_id)
VALUES (1,
        'As you grow older, you will discover that you have two hands, one for helping yourself, the other for helping others.',
        '1234-0000-1230', 200, '2022-12-12 17:24:44.000000', 'Title', 1, 1, 1, 1);
INSERT INTO libraryDB.book (id, description, isbn, number_of_page, publish_at, title, author_id, category_id,
                            language_id, publisher_id)
VALUES (2,
        '2 As you grow older, you will discover that you have two hands, one for helping yourself, the other for helping others.',
        '2234-0000-1230', 105, '2020-12-12 17:24:44.000000', 'Title 2', 2, 2, 2, 2);
####################################### loan #######################################
INSERT INTO libraryDB.loan (id, loan_data, return_data, book_id, user_id)
VALUES (1, '2022-12-12 17:29:00.000000', '2022-12-15 17:29:04.000000', 1, 1);
