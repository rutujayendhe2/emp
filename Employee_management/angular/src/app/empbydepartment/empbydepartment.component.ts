import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Department } from '../department';
import { DepartmentService } from '../service/department.service';

@Component({
  selector: 'app-empbydepartment',
  templateUrl: './empbydepartment.component.html',
  styleUrls: ['./empbydepartment.component.css']
})
export class EmpbydepartmentComponent {

  id:string;
  department:any;
  constructor(private activateRoute:ActivatedRoute, private departmentService:DepartmentService){
    this.activateRoute.paramMap.subscribe(data=>{
      this.id= data.get("depId");
      console.log(this.id);
    });

    departmentService.getEmployeeListByDeptName(this.id).subscribe(res =>{
      console.log(res);
      this.department=res;
    })
  }

}
