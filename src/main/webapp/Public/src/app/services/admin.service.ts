import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { AuthService } from './auth.service';
// import { JwtHelperService } from '@auth0/angular-jwt';

@Injectable({
  providedIn: 'root'
})
export class AdminService implements CanActivate{

  constructor(private router: Router,private auth:AuthService) { }
  canActivate(): boolean {
    if(this.auth.isAdmin()){
      return true;
    }else{
      localStorage.removeItem('loggedInUser');
      window.location.pathname="/login";
      return false;
    }
  }
}
