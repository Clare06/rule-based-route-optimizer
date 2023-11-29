import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { subscribeOn } from 'rxjs';
import { ENDPOINTS } from 'src/app/endpoints/rest.endpoints';
import { AuthService } from 'src/app/services/auth.service';
import { JwtService } from 'src/app/services/jwtservice.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  button:boolean = false;
  //role: string | null = null;
  data: any;
  forPass: boolean =false;
  otp: boolean = false;
  newPass: boolean = false;
  message: string="";
  userCred: any;
  otpmessage:string | null = null;
  email:any;
  temOTP:string | null = null;
  remainingTime:number =0;
  constructor(private jwt:JwtService,private service:UserService, private router: Router,private http: HttpClient, private authService:AuthService){}
  ngOnInit(): void {
      // this.http.get('http://localhost:8080/order/test').subscribe(data => console.log(data));

  }
  startTimer() {
    const duration = 5 * 60 * 1000; // 5 minutes in milliseconds
    const endTime = Date.now() + duration;

    const timer = setInterval(() => {
      const currentTime = Date.now();
      this.remainingTime = endTime - currentTime;

      if (this.remainingTime <= 0) {
        clearInterval(timer);
        window.location.reload();
        
      }
    }, 1000); // Update the remaining time every second
  }

  isForPass(){
    if(this.forPass){
      this.forPass=!this.forPass;
    }else{
      this.forPass=!this.forPass;
    }
  }
  forgPass(user:any){
    this.button=!this.button;
      this.otpmessage=null;
    this.http.post(ENDPOINTS.RESETPASS, user, { observe: 'response' }).subscribe(
      (response: HttpResponse<any>) => {
        if (response.status === 200) {
          // HTTP 200 OK, handle the success response
          this.otp=!this.otp;
          this.forPass=!this.forPass;
          this.email=user.email;
          this.startTimer();
          console.log('Success:', response ,this.email);
        } else {
          this.button=!this.button;
          this.otpmessage="Invalid email address";
          
          console.log('Other status:', response.status);
        }
      },
      (error) => {
        // Handle error response or network error
        this.otpmessage="Invalid email address";
        this.button=!this.button;
        console.error('Error occurred:', error);
      },
      () => {
        // Request completed
        console.log('Request completed');
      }
    );
  }
  otpSend(otp:any){
    this.otpmessage=null;
    otp.email=this.email;
    this.http.post(ENDPOINTS.VERIFYOTP, otp, { observe: 'response' }).subscribe(
      (response: HttpResponse<any>) => {
        if (response.status === 200) {
          // HTTP 200 OK, handle the success response
          this.newPass=!this.newPass;
          this.otp=!this.otp;
          this.temOTP=otp.otp;
          console.log('Success:', response);
        } else {
          this.otpmessage="Unmatched Otp";
          
          console.log('Other status:', response.status);
        }
      },
      (error) => {
        this.otpmessage="Unmatched Otp";
        console.error('Error occurred:', error);
      },
      () => {
        // Request completed
        console.log('Request completed');
      }
    );
  }
  newPassSend(newPass:any){
    this.otpmessage=null;
    newPass.email=this.email;
    newPass.otp=this.temOTP;
      console.log(newPass.email,this.email, newPass.confPass)
    this.http.post(ENDPOINTS.SETNEWPASS, newPass, { observe: 'response' }).subscribe(
      (response: HttpResponse<any>) => {
        if (response.status === 200) {
          alert("Password Reset Success")
          window.location.reload();
         
          console.log('Success:', response);
        } else {
          // Handle other HTTP status codes
          this.otpmessage="Passwords couldn't match";
          console.log('Other status:', response.status);
        }
      },
      (error) => {
        // Handle error response or network error
        console.error('Error occurred:', error);
        this.otpmessage="Passwords couldn't match";
      },
      () => {
        // Request completed
        console.log('Request completed');
      }
    );

  }
  authenticate(user: any){
    
    this.service.signIn(user).then(response=>{
        
     
        //localStorage.setItem('loggedInUser',user.email);
        
        this.data=JSON.parse(JSON.stringify(response))
       
        this.message="success";

        //  this.userCred= this.jwt.jwt_decode(this.data.token);
        //  localStorage.setItem('role',this.data.role);
          localStorage.setItem('loggedInUser',this.data.name);
          localStorage.setItem('profImg',this.data.profUrl);
          localStorage.setItem('token',this.data.token)
          // console.log(this.userCred.role)
          this.router.navigate(['../home']).then(()=>
                {
                  window.location.reload();
                });
      
    }).catch(error=>{
      console.log(error);
      this.message="Invalid email or password";


});
      

 }

 formatTime(milliseconds: number): string {
  const minutes = Math.floor(milliseconds / 1000 / 60);
  const seconds = Math.floor((milliseconds / 1000) % 60);
  return `${minutes.toString().padStart(2, '0')}:${seconds.toString().padStart(2, '0')}`;
}

     
}
