-- Create game table
DROP TABLE IF EXISTS player;
DROP TABLE IF EXISTS game;

CREATE TABLE game (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    background_url VARCHAR(255),
    active bool
);

-- Create player table
CREATE TABLE player (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    fullname VARCHAR(255),
    age VARCHAR(255),
    country VARCHAR(255),
    role VARCHAR(255),
    league VARCHAR(255),
    twitter VARCHAR(255),
    gamename VARCHAR(255),
    game_id BIGINT,
    FOREIGN KEY (game_id) REFERENCES game(id) ON DELETE CASCADE
);

-- You can continue to insert values for games and players as needed.

-- Insert Game: League of Legends
INSERT INTO game (name, background_url, active) VALUES ('League of Legends', 'lol', true);
-- Insert Game: Overwatch
INSERT INTO game (name, background_url, active) VALUES ('Overwatch', 'ow', true);
-- Insert Game: Valorant
INSERT INTO game (name, background_url, active) VALUES ('Valorant', 'valo', false);

INSERT INTO game (name, background_url, active) VALUES ('Counter Strike 2', 'cs2', true);


-- Insert Game: League of Legends

-- Insert Players for League of Legends
INSERT INTO player (name, fullname, age, country, role, league, twitter, gamename, game_id) VALUES ('Player1', 'Navn Navnesen','25', 'USA', 'Mid', 'NLC', '@Player1_LoL', 'League of Legends', 1);
INSERT INTO player (name, fullname, age, country, role, league, twitter, gamename, game_id) VALUES ('Player2', 'Navn Navnesen','22', 'UK', 'ADC', 'NLC', '@Player2_LoL', 'League of Legends', 1);
INSERT INTO player (name, fullname, age, country, role, league, twitter, gamename, game_id) VALUES ('Player3','Navn Navnesen', '23', 'Canada', 'Top', 'NLC', '@Player3_LoL', 'League of Legends', 1);
INSERT INTO player (name, fullname, age, country, role, league, twitter, gamename, game_id) VALUES ('Player4','Navn Navnesen', '24', 'Germany', 'Support', 'NLC', '@Player4_LoL', 'League of Legends', 1);
INSERT INTO player (name, fullname, age, country, role, league, twitter, gamename, game_id) VALUES ('Player5','Navn Navnesen', '21', 'France', 'Jungle', 'NLC', '@Player5_LoL', 'League of Legends', 1);

INSERT INTO player (name, fullname, age, country, role, league, twitter, gamename, game_id) VALUES ('Player6', 'Navn Navnesen','25', 'USA', 'Mid', 'GOODGAME-LIGAEN', '@Player6_LoL', 'League of Legends', 1);
INSERT INTO player (name, fullname, age, country, role, league, twitter, gamename, game_id) VALUES ('Player7', 'Navn Navnesen','22', 'UK', 'ADC', 'GOODGAME-LIGAEN', '@Player7_LoL', 'League of Legends', 1);
INSERT INTO player (name, fullname, age, country, role, league, twitter, gamename, game_id) VALUES ('Player8', 'Navn Navnesen','23', 'Canada', 'Top', 'GOODGAME-LIGAEN', '@Player8_LoL', 'League of Legends', 1);
INSERT INTO player (name, fullname, age, country, role, league, twitter, gamename, game_id) VALUES ('Player9','Navn Navnesen', '24', 'Germany', 'Support', 'GOODGAME-LIGAEN', '@Player9_LoL', 'League of Legends', 1);
INSERT INTO player (name, fullname, age, country, role, league, twitter, gamename, game_id) VALUES ('Player10','Navn Navnesen', '21', 'France', 'Jungle', 'GOODGAME-LIGAEN', '@Player10_LoL', 'League of Legends', 1);

-- Insert Players for Overwatch
INSERT INTO player (name, fullname, age, country, role, league, twitter, gamename, game_id) VALUES ('Player16','Navn Navnesen', '28', 'USA', 'Tank', 'GOODGAME-LIGAEN', '@Player6_Overwatch', 'Overwatch', 2);
INSERT INTO player (name, fullname, age, country, role, league, twitter, gamename, game_id) VALUES ('Player17','Navn Navnesen', '26', 'UK', 'DPS', 'GOODGAME-LIGAEN', '@Player7_Overwatch', 'Overwatch', 2);
INSERT INTO player (name, fullname, age, country, role, league, twitter, gamename, game_id) VALUES ('Player18','Navn Navnesen', '27', 'Canada', 'Healer', 'GOODGAME-LIGAEN', '@Player8_Overwatch', 'Overwatch', 2);
INSERT INTO player (name, fullname, age, country, role, league, twitter, gamename, game_id) VALUES ('Player19', 'Navn Navnesen','29', 'Germany', 'DPS', 'GOODGAME-LIGAEN', '@Player9_Overwatch', 'Overwatch', 2);
INSERT INTO player (name, fullname, age, country, role, league, twitter, gamename, game_id) VALUES ('Player20', 'Navn Navnesen','30', 'France', 'Tank', 'GOODGAME-LIGAEN', '@Player10_Overwatch', 'Overwatch', 2);

-- Insert Players for Valorant
INSERT INTO player (name, fullname, age, country, role, league, twitter, gamename, game_id) VALUES ('Player11', 'Navn Navnesen','23', 'USA', 'Controller', 'GOODGAME-LIGAEN', '@Player11_Valorant', 'Valorant', 3);
INSERT INTO player (name, fullname, age, country, role, league, twitter, gamename, game_id) VALUES ('Player12', 'Navn Navnesen','22', 'UK', 'Duelist', 'GOODGAME-LIGAEN', '@Player12_Valorant', 'Valorant', 3);
INSERT INTO player (name, fullname, age, country, role, league, twitter, gamename, game_id) VALUES ('Player13', 'Navn Navnesen','24', 'Canada', 'Initiator', 'GOODGAME-LIGAEN', '@Player13_Valorant', 'Valorant', 3);
INSERT INTO player (name, fullname, age, country, role, league, twitter, gamename, game_id) VALUES ('Player14','Navn Navnesen', '21', 'Germany', 'Sentinel', 'GOODGAME-LIGAEN', '@Player14_Valorant', 'Valorant', 3);
INSERT INTO player (name, fullname, age, country, role, league, twitter, gamename, game_id) VALUES ('Player15','Navn Navnesen', '25', 'France', 'Duelist', 'GOODGAME-LIGAEN', '@Player15_Valorant', 'Valorant', 3);


-- Insert Game: Counter Strike 2


-- Insert Players for Counter Strike 2
INSERT INTO player (name, fullname, age, country, role, league, twitter, gamename, game_id) VALUES ('Player21', 'John Smith','28', 'USA', 'Rifler', 'CSL', '@Player21_CS2', 'Counter Strike 2', 4);
INSERT INTO player (name, fullname, age, country, role, league, twitter, gamename, game_id) VALUES ('Player22', 'Jane Doe','26', 'UK', 'Sniper', 'CSL', '@Player22_CS2', 'Counter Strike 2', 4);
INSERT INTO player (name, fullname, age, country, role, league, twitter, gamename, game_id) VALUES ('Player23','Tom Johnson', '27', 'Canada', 'Support', 'CSL', '@Player23_CS2', 'Counter Strike 2', 4);
INSERT INTO player (name, fullname, age, country, role, league, twitter, gamename, game_id) VALUES ('Player24', 'Emily Davis','29', 'Germany', 'IGL', 'CSL', '@Player24_CS2', 'Counter Strike 2', 4);
INSERT INTO player (name, fullname, age, country, role, league, twitter, gamename, game_id) VALUES ('Player25', 'Robert Brown','30', 'France', 'Entry Fragger', 'CSL', '@Player25_CS2', 'Counter Strike 2', 4);
