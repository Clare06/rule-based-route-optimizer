import { HttpClient, HttpResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ENDPOINTS } from 'src/app/endpoints/rest.endpoints';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent {

  userForm!: FormGroup;
  message:String | null=null;
  create : Boolean = true;
  userObj: any;
  constructor(private router:Router,private formBuilder: FormBuilder,private http:HttpClient) {
    
  }

  ngOnInit() {
    this.userForm = this.formBuilder.group({
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required],
      role: ['', Validators.required],
      profImgUrl: ['', Validators.required],
      branch: ['', Validators.required],
      phone: ['', Validators.required]
    });
   this.http.get(ENDPOINTS.LISTUSER).subscribe(res=>{
        this.userObj=res;
   })
  }
  delete(id: number) {
      this.http.delete(ENDPOINTS.DELETEUSER+id).subscribe(res=>{

      })
      this.http.get(ENDPOINTS.LISTUSER).subscribe(res=>{
        this.userObj=res;
   })
      this.refreshPage();

  }
  onSubmit(user:any) {
    this.http.post(ENDPOINTS.CREATEUSER, user, { observe: 'response' }).subscribe(
      (response: HttpResponse<any>) => {
        if (response.status === 200) {
         alert("Success")
         this.refreshPage();
          
        } else {
          this.message="Invalids";
          
          console.log('Other status:', response.status);
        }
      },
      (error) => {
        // Handle error response or network error
        this.message="Invalid";
        console.error('Error occurred:', error);
      },
      () => {
        // Request completed
        console.log('Request completed');
      }
    );
    }
    refreshPage() {
      const currentUrl = this.router.url;
  this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
    this.router.navigate([currentUrl]);
  });
    }
    triger(){
      this.create=!this.create;
    }
    
}
