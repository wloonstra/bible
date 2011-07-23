DROP TABLE IF EXISTS category;

CREATE TABLE category(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(40)
);

INSERT INTO category VALUES
    (1, 'Aanbidding'),
    (2, 'Afwijzing'),
    (3, 'Angst'),
    (4, 'Bemoediging'),
    (5, 'Bescherming'),
    (6, 'Bezorgdheid'),
    (7, 'Blijdschap'),
    (8, 'Boosheid'),
    (9, 'Dankbaarheid'),
    (10, 'Dood'),
    (11, 'Eenzaamheid'),
    (12, 'Falen');
