DROP TABLE IF EXISTS biblecomment;

CREATE TABLE biblecomment(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    comment TEXT,
    placedate INT,
    bibletext_id INT);

DROP TABLE IF EXISTS bibletext_biblecomment;

CREATE TABLE bibletext_biblecomment(
    bibletext_id INT,
    biblecomment_id INT);
