import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  userRoles: string | null = null;
  private jwtHelper: JwtHelperService = new JwtHelperService();
  constructor(){}
  
  isWarehouse(): boolean{
    const token = localStorage.getItem('token');
    if (token) {
      const decodedToken = this.jwtHelper.decodeToken(token);
      if(decodedToken.role=='warehouse') {
      return true;
      }else{
        return false;
      }
    }
      return false;
  }
  isOutlet(): boolean{
    const token = localStorage.getItem('token');
    if (token) {
      const decodedToken = this.jwtHelper.decodeToken(token);
      if(decodedToken.role=='outletuser') {
      return true;
      }else{
        return false;
      }
    }
      return false;
  }
  isAdmin(): boolean{
    const token = localStorage.getItem('token');
    if (token) {
      const decodedToken = this.jwtHelper.decodeToken(token);
      if(decodedToken.role=='admin') {
      return true;
      }else{
        return false;
      }
    }
      return false;
  }
  isDriver(): boolean{
    const token = localStorage.getItem('token');
    if (token) {
      const decodedToken = this.jwtHelper.decodeToken(token);
      if(decodedToken.role=='driver') {
      return true;
      }else{
        return false;
      }
    }
      return false;
  }
  userRole(): string{
    const token = localStorage.getItem('token');
    if (token) {
    const decodedToken = this.jwtHelper.decodeToken(token);
     return decodedToken.role;
    }
    return "";
  }
  userBranch(): string{
    const token = localStorage.getItem('token');
    if (token) {
    const decodedToken = this.jwtHelper.decodeToken(token);
     return decodedToken.branch;
    }
    return "";
  }
  userID(): number{
    const token = localStorage.getItem('token');
    if (token) {
    const decodedToken = this.jwtHelper.decodeToken(token);
     return decodedToken.id;
    }
    throw new Error('Token not found');
  }
}
