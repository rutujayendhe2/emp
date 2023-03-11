import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  httpOptions = {
  
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    
     };
  constructor(private httpclient:HttpClient) { }

  getUsers():Observable <any>
  {
    return this.httpclient.get<any>('http://localhost:8080/users/findAll');
    }
    
  userLogin(user:any):Observable<any> {

    return this.httpclient.post<any>('http://localhost:8080/authenticate/login',user);

  }

  addUsers(firstName:string,lastName:string,emailAdd:string,phoneNo:number,address:string,password:string){

    const user={firstName:firstName,lastName:lastName,emailAdd:emailAdd,phoneNo:phoneNo,address:address,password:password};
    console.log(user);
    this.httpclient.post('http://localhost:8080/users/add',user).subscribe((data: any)=>{

      console.log(data);

    })

   }
}
