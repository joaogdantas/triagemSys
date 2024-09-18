CREATE TABLE patients (
    id UUID NOT NULL,
    name VARCHAR(255) NOT NULL,
    birth VARCHAR(10) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    healthInsurance VARCHAR(255),
    city VARCHAR(255),
    state VARCHAR(2),

    PRIMARY KEY (ID)
);
