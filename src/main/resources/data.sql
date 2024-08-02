INSERT INTO vehicle (type, make, model, year, license_plate, vin)
SELECT 'Truck', 'Scania', 'R500', 2021, 'XYZ789', 'VIN9876543210'
    WHERE NOT EXISTS (SELECT 1 FROM vehicle WHERE vin = 'VIN9876543210');

INSERT INTO vehicle (type, make, model, year, license_plate, vin)
SELECT 'Bus', 'Man', 'Lion', 2022, 'DEF456', 'VIN2345678901'
    WHERE NOT EXISTS (SELECT 1 FROM vehicle WHERE vin = 'VIN2345678901');

INSERT INTO vehicle (type, make, model, year, license_plate, vin)
SELECT 'Truck', 'Volvo', 'FH16', 2023, 'GHI123', 'VIN3456789012'
    WHERE NOT EXISTS (SELECT 1 FROM vehicle WHERE vin = 'VIN3456789012');

INSERT INTO vehicle (type, make, model, year, license_plate, vin)
SELECT 'Bus', 'Volvo', 'B11R', 2022, 'ABC123', 'VIN1234567890'
    WHERE NOT EXISTS (SELECT 1 FROM vehicle WHERE vin = 'VIN1234567890');

INSERT INTO vehicle (type, make, model, year, license_plate, vin)
SELECT 'Truck', 'Scania', 'R500', 2021, 'XYZ789', 'VIN9876543210'
    WHERE NOT EXISTS (SELECT 1 FROM vehicle WHERE vin = 'VIN9876543210');

INSERT INTO vehicle (type, make, model, year, license_plate, vin)
SELECT 'Bus','Mecedes-Benz', 'Tourismo', 2023, 'JKL456', 'VIN4567890123'
    WHERE NOT EXISTS (SELECT 1 FROM vehicle WHERE vin = 'VIN4567890123');

INSERT INTO vehicle_status (vehicle_id, timestamp, latitude, longitude, speed, fuel_level, engine_status)
SELECT v.id, UNIX_TIMESTAMP('2023-06-01 09:15:00')*1000, 37.3382, -121.8863, 75.0, 0.9, 'Running'
FROM vehicle v
WHERE v.vin = 'VIN9876543210'
    LIMIT 1;

INSERT INTO vehicle_status (vehicle_id, timestamp, latitude, longitude, speed, fuel_level, engine_status)
SELECT v.id, UNIX_TIMESTAMP('2023-06-01 10:00:00')*1000, 37.7749, -122.4194, 60.5, 0.8, 'Running'
FROM vehicle v
WHERE v.vin = 'VIN2345678901'
    LIMIT 1;

INSERT INTO vehicle_status (vehicle_id, timestamp, latitude, longitude, speed, fuel_level, engine_status)
SELECT v.id, UNIX_TIMESTAMP('2023-06-01 10:45:00')*1000, 37.7749, -122.4194, 60.5, 0.8, 'Running'
FROM vehicle v
WHERE v.vin = 'VIN3456789012'
    LIMIT 1;

INSERT INTO vehicle_status (vehicle_id, timestamp, latitude, longitude, speed, fuel_level, engine_status)
SELECT v.id, UNIX_TIMESTAMP('2023-06-01 11:30:00')*1000, 37.7749, -122.4194, 60.5, 0.8, 'Running'
FROM vehicle v
WHERE v.vin = 'VIN1234567890'
    LIMIT 1;
