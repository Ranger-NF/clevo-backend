-- Insert a recycler user
INSERT INTO users (id, username, email, password, role)
VALUES ('ac36ead1-c59c-45c5-93bf-616c41ade038', 'recycler1', 'recycler@example.com', 'password123', 'RECYCLER');

-- Insert a citizen user
INSERT INTO users (id, username, email, password, role)
VALUES ('e062eae1-05c6-4a2e-b742-671bf4348dcc', 'citizen1', 'john@example.com', 'password123', 'CITIZEN');

-- Insert a ward
INSERT INTO ward (id, name, description)
VALUES ('c60b3b3a-9ca7-400b-9459-4362ed687cdd', 'Ward 1', 'Central city ward');

-- Insert waste categories
INSERT INTO waste_category (id, name, description, eco_points_per_unit)
VALUES ('8047f110-b649-41ad-90e3-5e69efe9ddda', 'Plastic', 'Plastic waste', 5.0);

INSERT INTO waste_category (id, name, description, eco_points_per_unit)
VALUES ('f9af3295-8ee7-4ac7-89dc-3c444e576c3f', 'Glass', 'Glass bottles and jars', 7.0);

-- Insert a pickup slot for the recycler
INSERT INTO pickup_slot (id, recycler_id, ward_id, start_time, end_time, capacity, is_active, current_bookings_count)
VALUES ('11111111-2222-3333-4444-555555555555', 'ac36ead1-c59c-45c5-93bf-616c41ade038',
        'c60b3b3a-9ca7-400b-9459-4362ed687cdd', '2025-09-04 09:00:00', '2025-09-04 11:00:00', 20, true, 0);

-- Insert a booking
INSERT INTO booking (id, citizen_id, pickup_slot_id, waste_category_id, status, confirmation_code, estimated_quantity, actual_quantity, created_at, updated_at)
VALUES ('99999999-aaaa-bbbb-cccc-111111111111', 'e062eae1-05c6-4a2e-b742-671bf4348dcc',
        '11111111-2222-3333-4444-555555555555', '8047f110-b649-41ad-90e3-5e69efe9ddda',
        'PENDING', 'ABC123', 10.0, null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
