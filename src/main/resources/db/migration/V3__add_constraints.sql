-- Adding NOT NULL and CHECK constraint for title
ALTER TABLE courses
MODIFY COLUMN title VARCHAR(255) NOT NULL;

-- Adding CHECK constraint for status
ALTER TABLE courses
ADD CONSTRAINT chk_status CHECK (status IN ('Published', 'Pending'));


-- Adding NOT NULL and CHECK constraint for is_premium
ALTER TABLE courses
MODIFY COLUMN is_premium BOOLEAN NOT NULL;


-- Adding CHECK constraint for deleted_at
ALTER TABLE courses
ADD CONSTRAINT chk_deleted_at CHECK (deleted_at >= created_at);
