import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { ENDPOINTS } from '../endpoints/rest.endpoints';
import { AuthResponse } from '../components/login/schema/authResponse';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) { }
  
  signIn(user: any){
   
return this.http.post<AuthResponse>(ENDPOINTS.LOGIN,user).toPromise();
         // return this.http.post("http://localhost:8080/api/user/auth",user).toPromise();
         //return this.http.post(ENDPOINTS.LOGIN,user);
  }
}
