-- Initialisation des tables
INSERT INTO Country(id, code, name) VALUES
    (1, 'FR', 'France'), -- Les clés sont auto-générées
    (2, 'UK', 'United Kingdom'),
    (3, 'US', 'United States of America');

INSERT INTO CITY(name, population, country_id) VALUES
    ('Paris', 12, 1),
    ('Castres', 8, 1),
    ('London', 18, 2),
    ('New York', 27, 3);