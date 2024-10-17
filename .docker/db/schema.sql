CREATE TABLE IF NOT EXISTS flights (
    id VARCHAR(8) NOT NULL,
    departure_time TIMESTAMP NOT NULL,
    arrival_time TIMESTAMP NOT NULL,
    departure_airport VARCHAR(3) NOT NULL,
    arrival_airport VARCHAR(3) NOT NULL,
    departure_timezone VARCHAR(30) NOT NULL,
    arrival_timezone VARCHAR(30) NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS customers (
    id SERIAL PRIMARY KEY,
    passport_id VARCHAR(20) NOT NULL UNIQUE,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL
);

CREATE UNIQUE INDEX IF EXISTS customers__passport_id_idx ON customers (passport_id);


CREATE TABLE IF NOT EXISTS passengers (
    flight_id VARCHAR(8) NOT NULL REFERENCES flights(id),
    customer_id INT NOT NULL REFERENCES customers(id),
    PRIMARY KEY (flight_id, customer_id)
);

-- clean up before inserting fresh data
TRUNCATE TABLE passengers, customers, flights;

INSERT INTO flights (id, departure_time, arrival_time, departure_airport, arrival_airport, departure_timezone, arrival_timezone) VALUES
    -- International Flights
    -- Flight from Jakarta (CGK) to Bangkok (BKK)
    ('AAA02', '2024-12-02T10:00:00Z', '2024-12-02T13:00:00Z', 'CGK', 'BKK', 'Asia/Jakarta', 'Asia/Bangkok'),
    -- Flight from Los Angeles (LAX) to Tokyo (HND)
    ('AAA03', '2024-12-03T02:00:00Z', '2024-12-03T10:00:00Z', 'LAX', 'HND', 'America/Los_Angeles', 'Asia/Tokyo'),
    -- Flight from London (LHR) to New York (JFK)
    ('AAA04', '2024-12-04T14:00:00Z', '2024-12-04T18:00:00Z', 'LHR', 'JFK', 'Europe/London', 'America/New_York'),
    -- Flight from Sydney (SYD) to Auckland (AKL)
    ('AAA05', '2024-12-05T06:00:00Z', '2024-12-05T10:00:00Z', 'SYD', 'AKL', 'Australia/Sydney', 'Pacific/Auckland'),
    -- Flight from Dubai (DXB) to Paris (CDG)
    ('AAA06', '2024-12-06T08:00:00Z', '2024-12-06T13:00:00Z', 'DXB', 'CDG', 'Asia/Dubai', 'Europe/Paris'),
    -- Flight from New Delhi (DEL) to Singapore (SIN)
    ('AAA07', '2024-12-07T20:00:00Z', '2024-12-07T23:00:00Z', 'DEL', 'SIN', 'Asia/Kolkata', 'Asia/Singapore'),
    -- Flight from Seoul (ICN) to Beijing (PEK)
    ('AAA08', '2024-12-08T09:00:00Z', '2024-12-08T10:30:00Z', 'ICN', 'PEK', 'Asia/Seoul', 'Asia/Shanghai'),
    -- Flight from Mexico City (MEX) to Miami (MIA)
    ('AAA09', '2024-12-09T12:00:00Z', '2024-12-09T16:00:00Z', 'MEX', 'MIA', 'America/Mexico_City', 'America/New_York'),

    -- Domestic Flights (Thailand)
    -- Domestic flight from Bangkok (DMK) to Chiang Mai (CNX)
    ('AAA10', '2024-12-10T06:00:00Z', '2024-12-10T07:30:00Z', 'DMK', 'CNX', 'Asia/Bangkok', 'Asia/Bangkok'),
    -- Domestic flight from Phuket (HKT) to Bangkok (BKK)
    ('AAA11', '2024-12-11T14:00:00Z', '2024-12-11T15:30:00Z', 'HKT', 'BKK', 'Asia/Bangkok', 'Asia/Bangkok'),
    -- Domestic flight from Udon Thani (UTH) to Chiang Mai (CNX)
    ('AAA12', '2024-12-12T08:00:00Z', '2024-12-12T09:30:00Z', 'UTH', 'CNX', 'Asia/Bangkok', 'Asia/Bangkok'),
    -- Domestic flight from Surat Thani (URT) to Bangkok (DMK)
    ('AAA13', '2024-12-13T10:00:00Z', '2024-12-13T11:30:00Z', 'URT', 'DMK', 'Asia/Bangkok', 'Asia/Bangkok'),
    -- Domestic flight from Chiang Rai (CEI) to Phuket (HKT)
    ('AAA14', '2024-12-14T12:00:00Z', '2024-12-14T14:30:00Z', 'CEI', 'HKT', 'Asia/Bangkok', 'Asia/Bangkok'),
    -- Domestic flight from Hat Yai (HDY) to Udon Thani (UTH)
    ('AAA15', '2024-12-15T18:00:00Z', '2024-12-15T19:30:00Z', 'HDY', 'UTH', 'Asia/Bangkok', 'Asia/Bangkok');