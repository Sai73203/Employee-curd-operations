import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { Router } from '@angular/router';
import { EmployeeUpdateComponent } from '../employee-update/employee-update.component';

@Component({
  selector: 'app-employee-list',
  standalone: true,
  imports: [CommonModule,HttpClientModule,EmployeeUpdateComponent],
  providers:[EmployeeService],
  templateUrl: './employee-list.component.html',
  styleUrl: './employee-list.component.css'
})
export class EmployeeListComponent implements OnInit{

  //employees:Observable<Employee[]>;
  employees: any[] = [];

  constructor(private employeeService:EmployeeService,private router:Router){}

  ngOnInit(){
    this.getAllEmployeesList();
  }

  // getAllEmployeesList(){
  //   this.employees = this.employeeService.getAllEmployeesList();
  // }

  getAllEmployeesList() {
  this.employeeService.getAllEmployeesList().subscribe(data => {
    console.log(data);   // print's the data in console.
    this.employees = data;
  });
}

  updateEmployeeById(id:number){
    alert("want to update!");
    this.router.navigate(['/updateEmployee',id]);
  }


  deleteEmployeeById(id: number) {

    alert("want to delete!");
    this.employeeService.deleteEmployeeById(id).subscribe(() => {
      console.log("Deleted successfully");

    // this.getAllEmployeesList(); it work's after reload the page only. it shows table

    this.employees = this.employees.filter(emp=>emp.id!==id);
    
  });
}
  






}
