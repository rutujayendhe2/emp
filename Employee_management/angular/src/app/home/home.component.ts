import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Department } from '../department';
import { DepartmentService } from '../service/department.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  departments:Department[];

  constructor(private departmentService: DepartmentService,
    private router: Router) { }

  ngOnInit(): void {
    this.getDepartmentList();
  }

 getDepartmentList(){
    this.departmentService.getDepartmentList().subscribe(data => {
      this.departments = data;
      console.log(data);
    });
  }
}
