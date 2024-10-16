CREATE TABLE IF NOT EXISTS patients(
    id UUID PRIMARY KEY,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by UUID NOT NULL,
    name VARCHAR(255) NOT NULL,
    birth VARCHAR(255),
    rg VARCHAR(50),
    cpf VARCHAR(50),
    electoral_card VARCHAR(50),
    cns VARCHAR(50),
    mother_name VARCHAR(255),
    father_name VARCHAR(255),
    address_line_one VARCHAR(255),
    address_line_two VARCHAR(255),
    address_number VARCHAR(20),
    city VARCHAR(255),
    state VARCHAR(2),
    cep VARCHAR(20),
    blood_type VARCHAR(10),
    is_blood_donor BOOLEAN,
    is_organ_donor BOOLEAN,
    is_bone_marrow_donor BOOLEAN,
    notes VARCHAR(1024)
);

