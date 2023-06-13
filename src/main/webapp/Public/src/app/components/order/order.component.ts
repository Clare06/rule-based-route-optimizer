import { Component,OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import { JwtService } from 'src/app/services/jwtservice.service';
import { OrderserviceService } from 'src/app/services/orderservice.service';
import { Time } from '@angular/common';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})

export class OrderComponent {

  role: any;

// currentItem ='hey';


  constructor(private jwt:JwtService,private router: Router,private rolserve: AuthService,private orderService: OrderserviceService, private http: HttpClient){

  }
    ngOnInit(): void {
     

      this.role=this.rolserve.userRole();
      console.log(this.role);
     
    }
    isOrderReq(): boolean{
      return this.router.url==='/order';
    }

    isReturnReq(): boolean{
      return this.router.url.startsWith('/order/returnreq');
    }

}
