DROP TABLE IF EXISTS category;

CREATE TABLE category(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(40)
);

INSERT INTO category VALUES
    (1, 'Bemoediging'),
    (2, 'Vertrouwen'),
    (3, 'Nabijheid'),
    (4, 'Liefde'),
    (5, 'Aanwezigheid');
