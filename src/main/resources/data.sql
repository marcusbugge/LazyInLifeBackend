DROP TABLE IF EXISTS game_players CASCADE;
DROP TABLE IF EXISTS games CASCADE;
DROP TABLE IF EXISTS players CASCADE;

CREATE TABLE players (
                         id SERIAL PRIMARY KEY,
                         name VARCHAR(50) NOT NULL,
                         role VARCHAR(50) NOT NULL,
                         twitter VARCHAR(50)
);

CREATE TABLE games (
                       id SERIAL PRIMARY KEY,
                       name VARCHAR(50) NOT NULL,
                       picture VARCHAR(50) NOT NULL

);

CREATE TABLE game_players (
                              game_id INTEGER NOT NULL,
                              player_id INTEGER NOT NULL,
                              FOREIGN KEY (game_id) REFERENCES games (id) ON DELETE CASCADE,
                              FOREIGN KEY (player_id) REFERENCES players (id) ON DELETE CASCADE
);


-- Game records
INSERT INTO games (name, picture) VALUES
                             ('League of Legends', 'lol'),
                             ('Overwatch', 'ow'),
                             ('Valorant', 'valo');

-- Players records
INSERT INTO players (name, role, twitter) VALUES
                                              ('Player1', 'Midlaner', 'twitter1'),
                                              ('Player2', 'Support', 'twitter2'),
                                              ('Player3', 'ADC', 'twitter3'),
                                              ('Player4', 'Jungler', 'twitter4'),
                                              ('Player5', 'Toplaner', 'twitter5');

-- Assign players to games
INSERT INTO game_players (game_id, player_id) VALUES
                                                  (1, 1),
                                                  (1, 2),
                                                  (2, 3),
                                                  (2, 4),
                                                  (3, 5);

