CREATE TABLE IF NOT EXISTS vehicle (
                                       id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                       type VARCHAR(255),
    make VARCHAR(255),
    model VARCHAR(255),
    year INT,
    license_plate VARCHAR(255),
    vin VARCHAR(255)
    );

CREATE TABLE IF NOT EXISTS vehicle_status (
                                              id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                              vehicle_id BIGINT,
                                              timestamp TIMESTAMP,
                                              latitude DOUBLE,
                                              longitude DOUBLE,
                                              speed DOUBLE,
                                              fuel_level DOUBLE,
                                              engine_status VARCHAR(255),
    FOREIGN KEY (vehicle_id) REFERENCES vehicle(id)
    );