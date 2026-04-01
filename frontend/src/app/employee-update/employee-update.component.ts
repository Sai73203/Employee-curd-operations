import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { Employee } from '../employee';

@Component({
  selector: 'app-employee-update',
  standalone: true,
  imports: [FormsModule,CommonModule,HttpClientModule],
  providers:[EmployeeService],
  templateUrl: './employee-update.component.html',
  styleUrl: './employee-update.component.css'
})
export class EmployeeUpdateComponent implements OnInit {

  id!: number;
  employee: Employee = new Employee();

  constructor(private employeeService: EmployeeService, private router: Router, private route: ActivatedRoute) {}

  ngOnInit(){
      
    this.id = this.route.snapshot.params['id'];

    this.employeeService.getEmployeeById(this.id).subscribe(data => {
      this.employee = data;
    });
  }

  updateEmp(){
    alert("updating employee!!");

    this.employeeService.updateEmployeeById(this.id, this.employee)
      .subscribe(() => {
        this.router.navigate(['/employeeList']);
      });
  }
}
