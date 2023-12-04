INSERT INTO courses (title, description, status, is_premium, created_at)
VALUES ('Introduction to Programming', 'Learn the basics of programming', 'Published', true, CURRENT_TIMESTAMP);

INSERT INTO courses (title, description, status, is_premium, created_at)
VALUES ('Advanced Data Structures', 'Explore advanced data structure concepts', 'Pending', false, CURRENT_TIMESTAMP);

INSERT INTO courses (title, description, status, is_premium, created_at)
VALUES ('Web Development Fundamentals', 'Build foundational skills for web development', 'Published', true, CURRENT_TIMESTAMP);

INSERT INTO courses (title, description, status, is_premium, created_at, deleted_at)
VALUES ('C++', 'This course is no longer available', 'Published', true, '2002-01-01 12:00:00', '2022-03-15 10:30:00');

