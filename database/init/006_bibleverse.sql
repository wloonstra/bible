DROP TABLE IF EXISTS bibleverse;

CREATE TABLE bibleverse (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    book_id INT,
    chapter INT,
    verse INT,
    text TEXT);
     
DROP TABLE IF EXISTS bibletext_bibleverse;

CREATE TABLE bibletext_bibleverse (
    bibletext_id INT,
    bibleverse_id INT);
