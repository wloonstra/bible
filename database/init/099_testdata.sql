TRUNCATE TABLE user;
TRUNCATE TABLE bibletext;

INSERT INTO user (
    username, email
) VALUES
('wiggert','test@example.com');

INSERT INTO bibletext (
    book_id, startChapter, startVerse, endChapter, endVerse, text, user_id, motivation, category_id
) VALUES 
(45, 12, 1, 0, 0, '', 1, 'Dit is de eerste tekst van de site', 1),
(46, 6, 20, 0, 0, '', 1, '', 1),
(19, 50, 15, 0, 0, '', 1, '', 1),
(19, 86, 12, 0, 0, '', 1, '', 1),
(40, 5, 16, 0, 0, '', 1, '', 1),
(51, 3, 13, 0, 0, '', 1, '', 1),
(51, 3, 17, 0, 0, '', 1, '', 1),
(19, 22, 24, 0, 0, '', 1, '', 1),
(19, 27, 10, 0, 0, '', 1, '', 2),
(43, 6, 37, 0, 0, '', 1, '', 2),
(19, 9, 11, 0, 0, '', 1, '', 2),
(52, 4, 8, 0, 0, '', 1, '', 2),
(62, 3, 1, 0, 0, '', 1, '', 2),
(20, 18, 24, 0, 0, '', 1, '', 2),
(49, 1, 4, 0, 0, '', 1, '', 2),
(19, 94, 14, 94, 15, '', 1, '', 2),
(19, 103, 17, 103, 18, '', 1, '', 3),
(19, 138, 3, 0, 0, '', 1, '', 3),
(19, 138, 7, 0, 0, '', 1, '', 3),
(5, 31, 6, 0, 0, '', 1, '', 3),
(19, 37, 3, 37 ,4, '', 1, '', 3),
(23, 41, 10, 0, 0, '', 1, '', 3),
(55, 1, 7, 0, 0, '', 1, '', 3),
(43, 14, 27, 0, 0, '', 1, '', 3),
(19, 56, 3, 56, 4, '', 1, '', 3);    

INSERT INTO biblecomment (
    user_id, comment, placedate, bibletext_id
) VALUES
(1, "Dit is een mooie tekst", 1333000000, 1),
(1, "Dit is een reactie op een mooie tekst", 1333000010, 1),
(1, "Dit is een mooie tekst", 1333000000, 1),
(1, "Dit is een mooie tekst", 1333000000, 2),
(1, "Dit is een mooie tekst", 1333000000, 4),
(1, "Dit is een mooie tekst", 1333000000, 6),
(1, "Dit is een mooie tekst", 1333000000, 7),
(1, "Dit is een mooie tekst", 1333000000, 8),
(1, "Dit is een mooie tekst", 1333000000, 10),
(1, "Dit is een mooie tekst", 1333000000, 11),
(1, "Dit is een mooie tekst", 1333000000, 19),
(1, "Dit is een mooie tekst", 1333000000, 20),
(1, "Dit is een mooie tekst", 1333000000, 22);

INSERT INTO bibletext_biblecomment (
    bibletext_id, biblecomment_id
) VALUES
(1,1),
(1,2),
(1,3),
(2,4),
(4,5),
(6,6),
(7,7),
(8,8),
(10,9),
(11,10),
(19,11),
(20,12),
(22,13);
