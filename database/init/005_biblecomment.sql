DROP TABLE IF EXISTS biblecomment;

CREATE TABLE biblecomment(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    comment TEXT,
    placedate INT,
    bibletext_id INT);
