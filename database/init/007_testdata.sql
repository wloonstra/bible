TRUNCATE TABLE bibletext;

INSERT INTO bibletext (
    book_id, startChapter, startVerse, endChapter, endVerse, user_id, motivation, category_id
) VALUES 
(45, 12, 1, 0, 0, 1, 'Dit is de eerste tekst van de site', 1),
(46, 6, 20, 0, 0, 1, '', 1),
(19, 50, 15, 0, 0, 1, '', 1),
(19, 86, 12, 0, 0, 1, '', 1),
(40, 5, 16, 0, 0, 1, '', 1),
(51, 3, 13, 0, 0, 1, '', 1),
(51, 3, 17, 0, 0, 1, '', 1),
(19, 22, 24, 0, 0, 1, '', 1),
(19, 27, 10, 0, 0, 1, '', 2),
(43, 6, 37, 0, 0, 1, '', 2),
(19, 9, 11, 0, 0, 1, '', 2),
(52, 4, 8, 0, 0, 1, '', 2),
(62, 3, 1, 0, 0, 1, '', 2),
(20, 18, 24, 0, 0, 1, '', 2),
(49, 1, 4, 0, 0, 1, '', 2),
(19, 94, 14, 94, 15, 1, '', 2),
(19, 103, 17, 103 ,18, 1, '', 3),
(19, 138, 3, 0, 0, 1, '', 3),
(19, 138, 7, 0, 0, 1, '', 3),
(5, 31, 6, 0, 0, 1, '', 3),
(19, 37, 3, 37 ,4, 1, '', 3),
(23, 41, 10, 0, 0, 1, '', 3),
(55, 1, 7, 0, 0, 1, '', 3),
(43, 14, 27, 0, 0, 1, '', 3),
(19, 56, 3, 56 ,4, 1, '', 3);    
