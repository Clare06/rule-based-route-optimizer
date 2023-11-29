import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from 'src/app/services/auth.service';
// import { JwtService } from 'src/app/services/jwtservice.service';



@Component({
  selector: 'app-homebody',
  templateUrl: './homebody.component.html',
  styleUrls: ['./homebody.component.css']
})
export class HomebodyComponent {
loggInUser:string | null=null;
conso: any;
role: any;
constructor(private authService : AuthService, private http:HttpClient){}
  ngOnInit(): void {
   
    this.loggInUser= localStorage.getItem('loggedInUser');
    
    this.role=this.authService.userRole();
   
    this.http.get('http://localhost:8080/order/test',{observe: 'body', responseType: 'text'}).subscribe(
      (respo) => {
        this.conso = respo; // 'data' will be of type 'string'
        
      }
    );
   
  }
  
}


