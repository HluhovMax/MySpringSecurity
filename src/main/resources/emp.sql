
CREATE TABLE department(
  id INT AUTO_INCREMENT NOT NULL PRIMARY KEY ,
  name VARCHAR(30)
);

CREATE TABLE employee(
  id INT AUTO_INCREMENT NOT NULL PRIMARY KEY ,
  name VARCHAR(30),
  salary int,
  birthday DATE,
  hire_date DATE
  );



# CREATE TABLE dept_empl(
#   department_id INT,
#   employee_id INT,
#   FOREIGN KEY (department_id) REFERENCES department(id),
#   FOREIGN KEY (employee_id) REFERENCES employee(id)
# );