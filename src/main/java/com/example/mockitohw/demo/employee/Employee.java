package com.example.mockitohw.demo.employee;

import org.springframework.stereotype.Component;

@Component
public class Employee {

        private Integer departmentId;
        private String name;
        private Integer salary;

        public Employee(Integer departmentId, String name, Integer salary) {
            this.departmentId = departmentId;
            this.name = name;
            this.salary = salary;
        }


         public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getDepartmentId() {
            return departmentId;
        }

        public void setId(Integer departmentId) {
            this.departmentId = departmentId;
        }


        public Integer getSalary() {
            return salary;
        }

        public void setSalary(Integer salary) {
            this.salary = salary;
        }

        @Override
         public String toString() {
            return String.format("Сотрудник: %s %s из отдела № %d с зарплатой %d",
                departmentId, name, salary);
    }
}
