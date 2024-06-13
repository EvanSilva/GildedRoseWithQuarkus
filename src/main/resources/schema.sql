DROP TABLE IF EXISTS TABLA_ITEMS;

CREATE TABLE TABLA_ITEMS
(
    ID INT AUTO_INCREMENT NOT NULL,
    NOMBRE VARCHAR(50) NOT NULL,
    QUALITY INT NOT NULL,
    SELL_IN INT NOT NULL,
    TIPO VARCHAR(20) NOT NULL CHECK (TIPO IN ('NORMAL', 'SULFURAS', 'BACKSTAGE PASS', 'AGED BRIE', 'CONJURED')),
    PRIMARY KEY (ID)
);

INSERT INTO TABLA_ITEMS (ID, NOMBRE, SELL_IN, QUALITY, TIPO) VALUES
(1000,'Elixir of the Mongoose', 7, 5, 'NORMAL'),
(1001,'Aged Brie', 0, 2, 'AGED BRIE'),
(1002,'Sulfuras, Hand of Ragnaros', 80, 0, 'SULFURAS'),
(1003,'Backstage passes to a TAFKAL80ETC concert', 20, 15, 'BACKSTAGE PASS'),
(1004,'Conjured Mana Cake', 6, 3, 'CONJURED'),
(1005,'Elixir of the Mongoose', 5, 7, 'NORMAL'),
(1006,'Aged Brie', 1, 1, 'AGED BRIE'),
(1007,'Sulfuras, Hand of Ragnaros', 80, -1, 'SULFURAS'),
(1008,'Backstage passes to a TAFKAL80ETC concert', 10, 5, 'BACKSTAGE PASS'),
(1009,'Conjured Mana Cake', 3, 1, 'CONJURED');