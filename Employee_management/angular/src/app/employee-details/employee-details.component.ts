import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../service/employee.service';

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})
export class EmployeeDetailsComponent {
  empId: number;
  employee: Employee;
  constructor(private route: ActivatedRoute, private employeService: EmployeeService) { }

  ngOnInit(): void {
    this.empId = this.route.snapshot.params['empId'];

    this.employee = new Employee();
    this.employeService.getEmployeeById(this.empId).subscribe( data => {
      this.employee = data;
    });
  }

}
