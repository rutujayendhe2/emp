import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  users:[]=[];
  login!: string;
  isvalidlogin=false

  constructor(private userService:UserService,private router:Router,private http:HttpClient) { }
  ngOnInit(): void {
  }
  onSubmit(form: NgForm) {
    // const email=form.value.emailadd;
    const users={emailAdd:form.value.emailAdd,password:form.value.password};
   
    this.userService.userLogin(users).subscribe((res: { userId: any; })=>{
    console.log(res);
    const userId=res.userId;    
     console.log(userId);
    if(res){
      this.router.navigate(['/employees']);
    }
  })
    }
}
