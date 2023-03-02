import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../service/employee.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent {
  employees: Employee[];
  page: number = 1;
  count: number = 0;
  tableSize: number = 7;
  tableSizes: any = [3, 6, 9, 12];

  constructor(private employeeService: EmployeeService,
    private router: Router) { }

  ngOnInit(): void {
    this.getEmployees();
  }

  private getEmployees(){
    this.employeeService.getEmployeesList().subscribe(data => {
      this.employees = data;
      
    });
  }
  onTableDataChange(event: any) {
    this.page = event;
    this.getEmployees();
  }
  onTableSizeChange(event: any): void {
    this.tableSize = event.target.value;
    this.page = 1;
    this.getEmployees();
  }

  employeeDetails(empId: number){
    this.router.navigate(['employee-details', empId]);
  }

  updateEmployee(empId: number){
    this.router.navigate(['update-employee', empId]);
  }

  deleteEmployee(empId: number){
    this.employeeService.deleteEmployee(empId).subscribe( data => {
      console.log(data);
      this.getEmployees();
    })
  }
}
