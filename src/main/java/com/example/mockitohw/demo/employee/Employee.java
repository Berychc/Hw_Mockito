package com.example.mockitohw.demo.employee;

    public class Employee {

        private int id;
        private String departmentName;
        private int salary;

        public Employee(int id, String departmentName, int salary) {
            this.id = id;
            this.departmentName = departmentName;
            this.salary = salary;
        }

        public String getEmployees() {
            return departmentName;
        }

        public void setEmployees(String departmentName) {
            this.departmentName = departmentName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }


        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }
}
