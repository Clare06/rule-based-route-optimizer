import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ENDPOINTS } from 'src/app/endpoints/rest.endpoints';
import { OrderpopupComponent } from '../orderpopup/orderpopup.component';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-driverhome',
  templateUrl: './driverhome.component.html',
  styleUrls: ['./driverhome.component.css']
})
export class DriverhomeComponent {
  driverDelivery:any;
  id:number | null=null;
  constructor( private auth:AuthService, private dialogRef : MatDialog,private http:HttpClient){}

  ngOnInit(){
    this.id=this.auth.userID();
  this.http.get(ENDPOINTS.DRIVERDELIVERY+this.id).subscribe(data=>
    {
      this.driverDelivery=data;
      console.log(this.driverDelivery[0].ddID)
    })
}

openDialog(item: any){
  // console.log(item);
  const orderID = item.order.oid;
  this.dialogRef.open(OrderpopupComponent , {
    data : item
  });
}
}