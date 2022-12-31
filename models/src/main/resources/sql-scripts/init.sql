-- Insert Narocila

INSERT INTO Orders (clientId, deliveryPersonId, providerId, address, clientScore, deliveryScore, comment, status) VALUES (1, 2, 1, 'Phorska 42a', null, null, 'Good pica', 'CLOSED');
INSERT INTO Orders (clientId, deliveryPersonId, providerId, address, clientScore, deliveryScore, comment, status) VALUES (1, 2, 1, 'Phorska 42a', null, null, null, 'CLOSED');
INSERT INTO Orders (clientId, deliveryPersonId, providerId, address, clientScore, deliveryScore, comment, status) VALUES (2, 1, 1, 'Phorska 42a', null, null, null, 'CLOSED');

-- Insert OrderItem

INSERT INTO OrderItems (name, price) VALUES ('Iskreno', 12.20);
INSERT INTO OrderItems (name, price) VALUES ('Dobra vila', 13.50);
INSERT INTO OrderItems (name, price) VALUES ('Klasika', 12.30);

INSERT INTO orders_orderitems (orderentity_id, items_id) VALUES (1, 2);
INSERT INTO orders_orderitems (orderentity_id, items_id) VALUES (1, 3);

INSERT INTO orders_orderitems (orderentity_id, items_id) VALUES (2, 1);

INSERT INTO orders_orderitems (orderentity_id, items_id) VALUES (3, 1);
INSERT INTO orders_orderitems (orderentity_id, items_id) VALUES (3, 3);