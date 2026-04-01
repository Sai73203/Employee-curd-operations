import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';
import { Employee } from '../employee';

@Component({
  selector: 'app-employee-add',
  standalone: true,
  imports: [CommonModule,HttpClientModule,FormsModule],
  providers:[EmployeeService],
  templateUrl: './employee-add.component.html',
  styleUrl: './employee-add.component.css'
})
export class EmployeeAddComponent {

  employee:Employee = new Employee();

  constructor(private employeeService: EmployeeService,private router:Router) {};

  saveEmp(){
    alert("hlo");
    this.saveEmployee();
  }

  saveEmployee(){
    this.employeeService.createNewEmployee(this.employee).subscribe(data => {
    this.employee = data;
    this.moveToEmployeeList();   // move AFTER success
  });
}

  moveToEmployeeList(){
    this.router.navigate(["/employeeList"]);
  }



}
