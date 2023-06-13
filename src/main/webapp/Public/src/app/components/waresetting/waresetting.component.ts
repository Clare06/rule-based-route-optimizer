import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { window } from 'rxjs';
import { ENDPOINTS } from 'src/app/endpoints/rest.endpoints';
import { JwtService } from 'src/app/services/jwtservice.service';
import { ByIdResponse } from './schema/byIdResponse';

@Component({
  selector: 'app-waresetting',
  templateUrl: './waresetting.component.html',
  styleUrls: ['./waresetting.component.css']
})
export class WaresettingComponent {

  set: boolean=false;
  profImg: string | null=null;
  sUID: string | null=null;
  // user: {name: string; email: string; password: string; imgURL: string;branch: string}[]=[];
  user !: ByIdResponse ;
  myForm: FormGroup;
  uploadForm: FormGroup;
  message: string | null=null;
  sRole:any;
  uRole:any;
  upDetails:any;
  upUser: any;
  setprof: boolean=false;
  updpmes:any;
  // role: any;
  constructor(private jwt:JwtService,private http: HttpClient, private fb: FormBuilder, private router:Router){
    this.myForm = this.fb.group({
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      phone: ['', [Validators.required,Validators.minLength(12),Validators.pattern(/^\+94[0-9]*$/),Validators.maxLength(12)]],
      branch: ['', Validators.required],
      currentPassword: ['', Validators.required],
      password: ['', [Validators.required, Validators.minLength(8),Validators.maxLength(14),Validators.pattern(/^(?=.*[!@#$%^&*_])(?=.*[A-Z])(?=.*[a-z])(?!.*[<>"]).{8,}$/
      )]],
      confirmPassword: ['', Validators.required]
    });
    this.uploadForm = this.fb.group({
      file: ['', Validators.required]
    });
  }
  

  ngOnInit(): void {
        this.profImg=localStorage.getItem('profImg');      
        this.uRole=localStorage.getItem('token');
        this.sRole=this.jwt.jwt_decode(this.uRole);
        this.sUID=this.sRole.id;
        this.http.get<ByIdResponse>(ENDPOINTS.GETUSERBYID+this.sUID).subscribe(response => {
        this.user=response;
        this.myForm.get('name')?.setValue(this.user.name);
        this.myForm.get('email')?.setValue(this.user.email);
        this.myForm.get('branch')?.setValue(this.user.branch);
        this.myForm.get('phone')?.setValue(this.user.phone);
    })
   
   console.log(ENDPOINTS.GETUSERBYID+this.sUID);
  }
  update(user:any){
          // if(this.set==false){
          //   delete user.password;
          //   console.log(user);
          // }
          if((this.user.password==user.currentPassword) || this.set==false){
                this.message="";
                  if(user.password==user.confirmPassword){
                    this.message="";
                  this.http.put(ENDPOINTS.UPDATEUSER+this.sUID,user).subscribe(data =>{
                    this.upDetails=data;
                  })

                  const currentUrl = this.router.url;
                              this.router.navigateByUrl('/', {skipLocationChange: true}).then(() => {
                              this.router.navigate([currentUrl]);
                              });
                  
                  }else{
                    this.message="New passwords do not match";
                  }

          }else{
              this.message="Current Password is incorrect";
          }
  console.log(this.user.password==user.currentPassword);
}
show() {
  this.setprof=false;
    this.set=true;
  }

  changeDP() {
    this.set=false;
   this.setprof=true
    console.log(this.setprof);
    
    }
    onFileSelect(event: any) {
      const file = (event.target as HTMLInputElement).files?.[0];
  if (file) {
        const file = event.target.files[0];
        this.uploadForm.get('file')?.setValue(file);
      }
    }
    updateDP(){
     
      const file:File= this.uploadForm.get('file')?.value;
     
      const formData= new FormData();
      formData.append('file',file);
    
      this.http.post(ENDPOINTS.UPDP+this.sUID,formData).subscribe(data=>{
        this.updpmes=JSON.parse(JSON.stringify(data));
        localStorage.setItem('profImg',this.updpmes.url);
        console.log(this.updpmes[0].url);
      })
      
      const currentUrl = this.router.url;
                              this.router.navigateByUrl('/', {skipLocationChange: true}).then(() => {
                              this.router.navigate([currentUrl]);
                              // localStorage.setItem('profImg',this.updpmes.url);
                              setTimeout(() => {
                                      location.reload();
                                    }, 10);
                              });

                             
    }
}
