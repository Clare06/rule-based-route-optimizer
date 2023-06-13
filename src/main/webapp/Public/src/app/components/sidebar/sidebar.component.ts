import { Component, OnInit ,Input} from '@angular/core';
import { Router } from '@angular/router';
import { JwtService } from 'src/app/services/jwtservice.service';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {

  sRole:any;
  uRole:any;
  role: any;
//  @Input() item:number | null =null; 
constructor(private jwt:JwtService,private router:Router){}

ngOnInit(): void {
  this.uRole=localStorage.getItem('token');
    this.sRole=this.jwt.jwt_decode(this.uRole);
    this.role=this.sRole.role;
}
 
  isSettings() :Boolean{
    return this.router.url==='/settings/' || this.router.url.startsWith('/settings');
  }
  isHome():Boolean{
    return this.router.url==='/home';
  }

  isOrder(): Boolean{
    return this.router.url==='/order' || this.router.url.startsWith('/order/returnreq');
  }
  isRoute():Boolean{
    return this.router.url==='/route' || this.router.url.startsWith('/route');
  }
  isStock():Boolean{
    return this.router.url==='/stock';
  }
  isHistory():Boolean{
    return this.router.url==='/history';
  }
  isVehicle() :Boolean{
    return this.router.url==='/vehicle';
  }
  isNotAdmin() :Boolean{
    return this.role!='admin';
  }
  isNotDriver() :Boolean{
    return this.role!='driver';
  }isAdmin(): Boolean {
    return this.router.url==='/user';
    }
  logout(){
    localStorage.removeItem('loggedInUser');
    localStorage.removeItem('token');
    localStorage.removeItem('profImg');
    // localStorage.removeItem('logghome');
    this.router.navigate(["/login"]).then(()=>{
      window.location.reload();
    })
  }
}
