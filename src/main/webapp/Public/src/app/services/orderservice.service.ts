import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ENDPOINTS } from '../endpoints/rest.endpoints';
import { Order } from './order';

@Injectable({
  providedIn: 'root'
})
export class OrderserviceService {
  private apiUrl = 'http://localhost:8080/order';
  private itemUrl = 'http://localhost:8080/item';
  private returnUrl = 'http://localhost:8080/backhaul';
  
  constructor(private http: HttpClient) { }

  public deleteOrder(oid:number) {
    // console.log(`${oid}`);
    return  this.http.delete(`http://localhost:8080/order/delete/${oid}`);
    
  }

  submitOrder(order: any): Observable<any> {
    return this.http.post(this.apiUrl, order);
  }

  submititems(cart: any): Observable<any> {
    return this.http.post(this.itemUrl, cart);
  }

  returnOrder(order: any): Observable<any> {
    return this.http.post(this.returnUrl, order);
  }
}
