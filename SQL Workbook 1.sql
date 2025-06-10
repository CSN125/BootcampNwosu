CREATE TABLE Dealerships(
Dealershipid INT AUTO_INCREMENT PRIMARY KEY,
Name VARCHAR(50) NOT NULL,
address VARCHAR(50),
phone VARCHAR(12) 
);

INSERT INTO Dealerships (Name, address, phone)
Values ('Red Rock Motors', '2500 Red Rock St, Las Vegas, NV','702555001'),
('Maple Auto Plaza','99 Maple Ave, Albany, NY', '5185550002'),
('Coastal Car Hub', '101 Ocean Dr, Miami, FL', '3055550003'),
('Prairie Auto Mall','777 Prairie Ln, Omaha, NE','4025550004'),
('Lone Star Autos','1201 Ranch Rd, Austin, TX','5125550005'),
('Great Lakes Motors','540 Lake Blvd, Chicago, IL','3125550006');

CREATE TABLE Vehicles(
Vin INT PRIMARY KEY NOT NULL,
Name VARCHAR(50) NOT NULL,
TYPE VARCHAR(20) NOT NULL,
Sold bit NOT NULL
);

INSERT INTO Vehicles ( Vin, Name, Type, Sold)
Values (10009,'BMW X5','SUV',0),
(10010,'Audi A4','Sedan',1),
(10011,'Mercedes C300','Sedan',0),
(10012,'Ford Mustang GT','Coupe',1),
(10013,'Volkswagen Golf','Hatchback',0),
(10014,'Kia Sorento','SUV',1),
(10015,'Nissan Rogue','SUV',0),
(10016,'Hyundai Elantra','Sedan',1);

CREATE TABLE Inventory(
Dealershipid INT,
Vin INT,
FOREIGN KEY (VIN) REFERENCES Vehicles(VIN),
FOREIGN KEY (Dealershipid) REFERENCES Dealerships(Dealershipid)
);

INSERT INTO Inventory (Dealershipid, Vin)
 VALUES (1, 10009),
(1, 10010),
(2, 10011),
(2, 10012),
(3, 10013),
(3, 10014),
(4, 10015),
(4, 10016);




CREATE TABLE Salescontract(
Contractid INT AUTO_INCREMENT PRIMARY KEY,
Vin INT,
Customername VARCHAR(50),
Salesprice DECIMAL(15),
Dealershipid INT,
ContractDate DATE,
FOREIGN KEY (Vin) REFERENCES Vehicles(Vin),
FOREIGN KEY (Dealershipid) REFERENCES Dealerships(Dealershipid)
);

INSERT INTO Salescontract (Vin, Customername, Salesprice, Dealershipid, ContractDate)
Values (10009,'Alex Johnson', 32995.00, 1,'2025-06-08'),
        (10010,'Brianna Smith',28950.00, 1,'2025-06-08'),
        (10011,'Carlos Gomez', 41500.00, 2,'2025-06-07'),
        (10012,'Dana   Lee',   19950.00, 2,'2025-06-07'),
        (10013,'Ethan  Patel', 22499.00, 3,'2025-06-06'),
        (10014,'Farah  Ahmed', 31999.00, 3,'2025-06-06'),
        (10015,'George Brown', 35999.00, 4,'2025-06-05'),
        (10016,'Hannah Wilson',18499.00, 4,'2025-06-05');
        
        
-- 1. Get all dealerships
SELECT *
FROM Dealerships;

-- 2. Find all vehicles for a specific dealership
SELECT *
FROM Vehicles 
JOIN inventory ON inventory.Vin = Vehicles.Vin 
WHERE DealershipID = 1 ; 
-- 3. Find a car by VIN
SELECT *
FROM vehicles
WHERE Vin=10010;
-- 4. Find the dealership where a certain car is located, by VIN
SELECT *
FROM dealerships
JOIN inventory ON inventory.DealershipID = dealerships.DealershipID
JOIN vehicles ON vehicles.Vin = inventory.Vin
WHERE vehicles.Vin = 10010;
-- 5. Find all Dealerships that have a certain car type (i.e. Red Ford Mustang)
SELECT*
FROM dealerships
JOIN inventory ON inventory.DealershipID = dealerships.DealershipID
JOIN vehicles ON vehicles.Vin = inventory.Vin
WHERE vehicles.Type = 'Sedan';

-- 6. Get all sales information for a specific dealer for a specific date range
SELECT *
FROM dealerships  
JOIN salescontact ON salescontact.DealershipID = dealerships.DealershipID
WHERE salescontact.ContractDate BETWEEN '2025-06-01' AND '2025-06-08';


