import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';






@Injectable({
  providedIn: 'root'
})
export class AuthguardService implements CanActivate {
  private jwtHelper: JwtHelperService = new JwtHelperService();
  constructor( private router: Router) {}

  canActivate(): boolean {
    const token = localStorage.getItem('token');
    if(token){
    const payload = this.jwtHelper.decodeToken(token);

      const expiryDate = new Date(0);
      expiryDate.setUTCSeconds(payload.exp);
      const isExpired = expiryDate < new Date();
      // console.log(expiryDate.setUTCSeconds(payload.exp));
      // console.log(new Date());
    if (localStorage.getItem('loggedInUser')==null || isExpired) {
     window.location.pathname="/login";
      return false;
    }
    return true;
  }
  return false;
}
  }

