INSERT INTO user (email, first_name, last_name, password, username) VALUES ('admin@admin.com', 'admin', 'admin', '$2a$04$n6WIRDQlIByVFi.5rtQwEOTAzpzLPzIIG/O6quaxRKY2LlIHG8uty', 'admin');
INSERT INTO role (description, name) VALUES ('ROLE_ADMIN', 'ADMIN');
INSERT INTO role (description, name) VALUES ('ROLE_USER', 'USER');
INSERT INTO role (description, name) VALUES ('ROLE_SUPERVISOR', 'SUPERVISOR');
INSERT INTO user_roles (user_id, role_id) VALUES ('1', '1');