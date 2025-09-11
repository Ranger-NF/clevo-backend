
-- Insert a ward (authority_id can be null or reference a user with AUTHORITY role)
INSERT INTO ward (id, name, description, authority_id)
VALUES ('c60b3b3a-9ca7-400b-9459-4362ed687cdd', 'Ward 1', 'Central city ward', NULL);

-- Insert waste categories
INSERT INTO waste_category (id, name, description, eco_points_per_unit)
VALUES ('8047f110-b649-41ad-90e3-5e69efe9ddda', 'Plastic', 'Plastic waste', 5.0);

INSERT INTO waste_category (id, name, description, eco_points_per_unit)
VALUES ('f9af3295-8ee7-4ac7-89dc-3c444e576c3f', 'Glass', 'Glass bottles and jars', 7.0);

-- Insert sample rewards
INSERT INTO reward (id, name, points)
VALUES (1, 'Free Recycling Bag', 100);

INSERT INTO reward (id, name, points)
VALUES (2, 'Discount Coupon', 200);
