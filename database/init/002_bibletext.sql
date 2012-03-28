DROP TABLE IF EXISTS bibletext;

CREATE TABLE bibletext (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    category_id INT,
    placedate INT
);
