import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private baseURL = "http://localhost:8080/employees";

  constructor(private httpClient: HttpClient) { }

  getEmployeesList(): Observable<Employee[]>{
    return this.httpClient.get<Employee[]>(`${this.baseURL}/findAll`);
  }

  createEmployee(employee: Employee): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}/add`, employee);
  }

  getEmployeeById(empId: number): Observable<Employee>{
    return this.httpClient.get<Employee>(`${this.baseURL}/employee/${empId}`);
  }

  updateEmployee(empId: number, employee: Employee): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/update/${empId}`, employee);
  }

  deleteEmployee(empId: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/delete/${empId}`);
  }
}

