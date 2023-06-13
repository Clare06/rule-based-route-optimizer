import { HttpClient } from '@angular/common/http';
import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-orderpopup',
  templateUrl: './orderpopup.component.html',
  styleUrls: ['./orderpopup.component.css']
})
export class OrderpopupComponent {
  driverDelivery:any;

  constructor(public dialogRef : MatDialogRef<OrderpopupComponent>, private http:HttpClient , @Inject(MAT_DIALOG_DATA) public data: any){}
  
  closeDialog(){
    this.dialogRef.close(OrderpopupComponent);
  }

  ngOnInit(): void{
  //  console.log(this.data.orderID);
   console.log(this.data);
  }
}
