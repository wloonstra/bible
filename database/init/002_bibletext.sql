CREATE TABLE bibletext (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    book_id INT,
    startChapter INT,
    startVerse INT,
    endChapter INT,
    endVerse INT,
    user_id INT);
     