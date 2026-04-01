import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseURL = "http://localhost:9001/api";

  constructor(private http:HttpClient) { }

  getAllEmployeesList():Observable<any>{
    return this.http.get(`${this.baseURL}/allEmployees`);
  }

  getEmployeeById(id:number):Observable<any>{
    return this.http.get(`${this.baseURL}/${id}`);
  }

  createNewEmployee(employee:Employee):Observable<any>{
    return this.http.post(`${this.baseURL}/createEmp`,employee);
  }

  updateEmployeeById(id:number,employee:Employee):Observable<any>{
    return this.http.put(`${this.baseURL}/${id}`,employee);
  }

  deleteEmployeeById(id:number):Observable<any>{
    return this.http.delete(`${this.baseURL}/${id}`);
  }



  
}
