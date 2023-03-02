import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  constructor(private userService:UserService) { }
  ngOnInit(): void {
  }
  onSubmit(form: NgForm) {
    console.log(form.value);
  this.userService.addUsers(form.value.Firstname,
    form.value.lastname,
    form.value.emailAdd,
    form.value.phoneNo,
    form.value.Address,

    form.value.password,
)
alert('Registration Success');
}

}
