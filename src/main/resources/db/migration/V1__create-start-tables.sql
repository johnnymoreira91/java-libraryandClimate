CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE author (
    id SERIAL PRIMARY KEY,
    public_id UUID DEFAULT uuid_generate_v4(),
    name TEXT NOT NULL,
    country_of_birth TEXT,
    date_of_birth DATE,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE book (
    id SERIAL PRIMARY KEY,
    public_id UUID DEFAULT uuid_generate_v4(),
    title TEXT NOT NULL,
    author_id INT REFERENCES author(id),
    description TEXT,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE user_account (
    id SERIAL PRIMARY KEY,
    public_id UUID DEFAULT uuid_generate_v4(),
    name TEXT NOT NULL,
    email TEXT UNIQUE NOT NULL,
    password TEXT NOT NULL,
    cpf TEXT UNIQUE NOT NULL,
    age INT,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW(),
    CONSTRAINT unique_email_user_account UNIQUE (email)
);

CREATE TABLE address (
    id SERIAL PRIMARY KEY,
    public_id UUID DEFAULT uuid_generate_v4(),
    user_id INT REFERENCES user_account(id),
    street TEXT,
    city TEXT,
    state TEXT,
    postal_code TEXT,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE phone (
    id SERIAL PRIMARY KEY,
    public_id UUID DEFAULT uuid_generate_v4(),
    user_id INT REFERENCES user_account(id),
    phone_number TEXT,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE reservation (
    id SERIAL PRIMARY KEY,
    public_id UUID DEFAULT uuid_generate_v4(),
    user_id INT REFERENCES user_account(id),
    book_id INT REFERENCES book(id),
    attendant_name TEXT,
    check_out TIMESTAMP,
    due_date TIMESTAMP,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE bookshelf (
    id SERIAL PRIMARY KEY,
    public_id UUID DEFAULT uuid_generate_v4(),
    book_id INT REFERENCES book(id),
    shelf_location TEXT,
    is_available BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);