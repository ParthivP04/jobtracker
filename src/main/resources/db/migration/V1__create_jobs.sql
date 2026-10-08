CREATE TABLE job (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    company VARCHAR(255) NOT NULL,
    location VARCHAR(255),
    url TEXT NOT NULL UNIQUE,
    source VARCHAR(50) NOT NULL,
    description TEXT,
    status VARCHAR(30) NOT NULL DEFAULT 'SAVED',
    match_score INTEGER,
    notes TEXT,
    applied_at DATE,
    follow_up_at DATE,
    created_at TIMESTAMP NOT NULL DEFAULT now()
);