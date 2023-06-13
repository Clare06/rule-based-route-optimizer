import { HttpClient } from '@angular/common/http';
import { Component, Injectable, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { ENDPOINTS } from 'src/app/endpoints/rest.endpoints';
import { GetorederService } from 'src/app/services/getoreder.service';
import { OrderserviceService } from 'src/app/services/orderservice.service';
import { DialogComponent } from '../dialog/dialog.component';
// import '../../../../node_modules/bootstrap/dist/css/bootstrap.min.css';
// import '../../../../node_modules/jquery/dist/jquery.min.js';
// import '../../../../node_modules/bootstrap/dist/js/bootstrap.min.js';
import { ProductpopComponent } from '../productpop/productpop.component';

@Component({
  selector: 'app-rorder',
  templateUrl: './rorder.component.html',
  styleUrls: ['./rorder.component.css']
})
export class RorderComponent implements OnInit {
  status: string | null = null;
  getOrder: any;
  a: number = 1;
  // submit: boolean = false;
  // public curOrder: number[] | undefined;
  private curOrder: number[] = [];
  errorMessage: any;
  getItem: any;
  someVariable: any;
  constructor(private getOrderService: GetorederService,
    private http: HttpClient,
    private orderService: OrderserviceService,
    private dialog: MatDialog,
    private router: Router

  ) { }
  ngOnInit(): void {
    this.http.get(ENDPOINTS.ORDERGET).subscribe(data => {
      this.getOrder = data;
    });
    // this.http.get(ENDPOINTS.ITEMGETBYOID+).subscribe(data=>{
    //   this.getItem = data;
    // })
    // console.log(this.getOrder);
  }


  public selectOrder(item: any) {
   this.someVariable=item;
    const dialogConfig = new MatDialogConfig();

    dialogConfig.data = {
      someData: this.someVariable
    };
    console.log(dialogConfig.data)
    
    for (var index in this.curOrder) {
      if (this.curOrder[index] == item) {
        // delete this.curOrder[index];
        this.curOrder.splice(parseInt(index), 1);
        console.log("42=>" + this.curOrder.length);
        console.log(this.curOrder);

        this.a = 0;
        // break;
      }
    }

    if (this.a==1) {
      const dialogRef = this.dialog.open(ProductpopComponent,dialogConfig);

    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
    });
    }

    if (this.a == 1) {
      this.curOrder.push(item);
      console.log("49=>" + this.curOrder);
    }
    this.a = 1;
    // console.log(item);
    // console.log("52=>"+this.curOrder);
  }
  public check(item: any): Boolean {

    for (var index in this.curOrder) {
      if (this.curOrder[index] == item) {
        return true;
      }
    }
    return false;
  }
  // productDropdown(oid:number){
  //   this.http.get(ENDPOINTS.ITEMGETBYOID+oid).subscribe(data=>{
  //       this.getItem = data;
  //     })
  // }

  // clickEvent(): void {
  //   this.status = !this.status;
  //   console.log(this.status);
  // }

  onCancel() {
    this.curOrder = [];
    console.log(this.curOrder);
  }
  isDisabled(): boolean {

    return this.curOrder.length == 0? true : false

  }
  openDialog() {
    const dialogRef = this.dialog.open(DialogComponent);

    dialogRef.afterClosed().subscribe(result => {
      console.log(`${result}` == "true");
      if (`${result}` == "true") {

        for (var index in this.curOrder) {
          console.log(`${this.curOrder[index]}`);
          // this.orderService.deleteOrder(this.curOrder[index]).subscribe({
          //   next: data => {
          //     this.status = 'Delete successful';
          //     console.log(this.status + "" + data);
          //   },
          //   error: error => {
          //     this.errorMessage = error.message;
          //     console.error('There was an error!', error);
          //   }
          // });
        }
        // this.submit=true;
        this.router.navigate(['/order/returnreq'], {queryParams: {variable : this.curOrder}});
      } else {
        this.curOrder = [];
      }
    });
  }

  
}

