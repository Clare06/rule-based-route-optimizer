import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
// import { JwtService } from 'src/app/services/jwtservice.service';



@Component({
  selector: 'app-homebody',
  templateUrl: './homebody.component.html',
  styleUrls: ['./homebody.component.css']
})
export class HomebodyComponent {
loggInUser:string | null=null;

role: any;
constructor(private authService : AuthService){}
  ngOnInit(): void {
   
    this.loggInUser= localStorage.getItem('loggedInUser');
    
    this.role=this.authService.userRole();
    console.log(this.role);
   
  }
  // isOrderReq(): boolean{
  //   return this.router.url==='/home';
  // }
  // isReturnReq(): boolean{
  //   return this.router.url==='/home/returnreq';
  // }
}
