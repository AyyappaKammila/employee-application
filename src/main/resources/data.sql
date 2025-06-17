INSERT INTO department (id, name, budget) VALUES (1, 'Engineering', 1000000);
INSERT INTO department (id, name, budget) VALUES (2, 'HR', 500000);

INSERT INTO project (id, name, start_date, end_date, department_id)
VALUES (1, 'Alpha', '2024-01-01', '2024-06-30', 1);
INSERT INTO project (id, name, start_date, end_date, department_id)
VALUES (2, 'Beta', '2024-03-01', '2024-09-30', 2);

INSERT INTO employee (id, name, email, department_id, date_of_joining, salary, manager_id)
VALUES (1, 'Alice', 'alice@example.com', 1, '2022-01-01', 75000, NULL);
INSERT INTO employee (id, name, email, department_id, date_of_joining, salary, manager_id)
VALUES (2, 'Bob', 'bob@example.com', 1, '2023-01-01', 72000, 1);
INSERT INTO employee (id, name, email, department_id, date_of_joining, salary, manager_id)
VALUES (3, 'Carol', 'carol@example.com', 2, '2024-01-15', 65000, 1);

INSERT INTO employee_project (employee_id, project_id, assigned_date, role)
VALUES (1, 1, '2024-01-10', 'Developer');
INSERT INTO employee_project (id, employee_id, project_id, assigned_date, role)
VALUES (2, 1, '2024-02-01', 'Tester');
INSERT INTO employee_project (id, employee_id, project_id, assigned_date, role)
VALUES (3, 2, '2024-03-01', 'Analyst');

INSERT INTO performance_review (id, employee_id, review_date, score, review_comments)
VALUES (1, 1, '2024-04-01', 90, 'Excellent');
INSERT INTO performance_review (id, employee_id, review_date, score, review_comments)
VALUES (2, 1, '2024-05-01', 85, 'Good');
INSERT INTO performance_review (id, employee_id, review_date, score, review_comments)
VALUES (3, 1, '2024-06-01', 88, 'Very Good');

INSERT INTO performance_review (id, employee_id, review_date, score, review_comments)
VALUES (4, 2, '2024-04-01', 70, 'Average');
INSERT INTO performance_review (id, employee_id, review_date, score, review_comments)
VALUES (5, 2, '2024-06-01', 75, 'Improving');
INSERT INTO performance_review (id, employee_id, review_date, score, review_comments)
VALUES (6, 3, '2024-05-15', 95, 'Outstanding');
