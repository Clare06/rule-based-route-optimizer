import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { JwtService } from 'src/app/services/jwtservice.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  loggInUser: string | null = null;
  // role: string | null=null;
  profImg: string | null=null;
  serverData: any;
  currentItem: number|null=3;
  sRole:any;
  uRole:any;
  role: any;

constructor(private jwt:JwtService,private router:Router,private activeRoute:ActivatedRoute, private http: HttpClient){}

  ngOnInit(): void {
    
    this.loggInUser= localStorage.getItem('loggedInUser'); 
    // this.role=localStorage.getItem('role');
    this.profImg=localStorage.getItem('profImg');
    this.uRole=localStorage.getItem('token');
    this.sRole=this.jwt.jwt_decode(this.uRole);
    this.role=this.sRole.role;
  }
  

}
