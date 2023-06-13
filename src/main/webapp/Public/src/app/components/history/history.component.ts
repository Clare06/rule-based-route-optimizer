import { HttpClient } from '@angular/common/http';
import { Component, Injectable, OnInit } from '@angular/core';
import { forkJoin, map, Observable } from 'rxjs';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit{
  
  oid!: number;
  userid: any;
  orders: any;
  myorders: any;

  constructor(private http: HttpClient,private auth:AuthService){

}

  ngOnInit(): void {
    this.userid=this.auth.userID();
    //getting all the orders
    const order_url = 'http://localhost:8080/order';
  this.http.get(order_url).subscribe((data: any) => {
  this.orders = data;
  
  this.myorders = this.orders.filter((item: any) => item.user.id == this.userid);

  let myproductsObs: Observable<any>[] = [];
  for(let i = 0; i < this.myorders.length; i++) {
    this.oid = this.myorders[i].oid;
    //getting set of item names for each order and it returns an observable for each order. pipe and map used to extract product names and returns an array of product names.
    let obs = this.http.get(`http://localhost:8080/item/group-by-oid/${this.oid}`)
      .pipe(
        map((data: any) => {
          let products = data.map((item: any) => item.product.productName);
          return products;
        })
      );
    myproductsObs.push(obs);
  }
  //combine the Observable objects in the myproductsObs array into a single Observable that emits an array of all the products for each order
  forkJoin(myproductsObs).subscribe((myproducts: any[]) => {
    for(let i = 0; i < this.myorders.length; i++) {
      this.myorders[i].products = myproducts[i];
    }
  });
});

    
  }
}
