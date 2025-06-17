
CREATE TABLE department (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    budget BIGINT NOT NULL
);

CREATE TABLE project (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    department_id BIGINT,
    CONSTRAINT fk_project_department FOREIGN KEY (department_id) REFERENCES department(id)
);

CREATE TABLE employee (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    department_id BIGINT,
    date_of_joining DATE NOT NULL,
    salary DECIMAL(10, 2) NOT NULL,
    manager_id BIGINT,
    CONSTRAINT fk_employee_department FOREIGN KEY (department_id) REFERENCES department(id),
    CONSTRAINT fk_employee_manager FOREIGN KEY (manager_id) REFERENCES employee(id)
);

CREATE TABLE employee_project (
    employee_id BIGINT NOT NULL,
    project_id BIGINT NOT NULL,
    assigned_date DATE,
    role VARCHAR(255),
    PRIMARY KEY (employee_id, project_id),
    CONSTRAINT fk_emp_proj_employee FOREIGN KEY (employee_id) REFERENCES employee(id),
    CONSTRAINT fk_emp_proj_project FOREIGN KEY (project_id) REFERENCES project(id)
);


CREATE TABLE performance_review (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    employee_id BIGINT NOT NULL,
    review_date DATE NOT NULL,
    score INT NOT NULL,
    review_comments VARCHAR(500),
    CONSTRAINT fk_review_employee FOREIGN KEY (employee_id) REFERENCES employee(id)
);
