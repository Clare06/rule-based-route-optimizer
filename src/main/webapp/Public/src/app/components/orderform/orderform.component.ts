import { Component,OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OrderserviceService } from 'src/app/services/orderservice.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Time } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { forkJoin } from 'rxjs';
import { MatSnackBar, MatSnackBarConfig } from '@angular/material/snack-bar';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-orderform',
  templateUrl: './orderform.component.html',
  styleUrls: ['./orderform.component.css']
})
export class OrderformComponent implements OnInit{

orderform: FormGroup;
cart: { pid: number, orderedQuantity: number }[] = [];
userid: any ;
userBranch:any;
pid!: number;
totalvolume: number = 0;
totalweight: number = 0;

products: any;

  constructor(private router: Router,private orderService: OrderserviceService, private http: HttpClient, private fb: FormBuilder,private snackBar: MatSnackBar,private auth:AuthService){
    this.orderform = this.fb.group({
      product: ['', Validators.required],
      quantity: [null, [Validators.required,Validators.min(1)]],
      address: [''],
      from: [''],
      to: ['']
    });
  }
    ngOnInit(): void {
      const product_url = 'http://localhost:8080/product';
      this.http.get(product_url).subscribe((data: any) => {
      this.products=data;
    });
      this.userid=this.auth.userID();
      this.userBranch=this.auth.userBranch();
      this.orderform.get('address')?.setValue(this.userBranch);  
    }


    onClick() {

    }
  
    onSubmit() {
      //directly submitting a single order without clicking add to cart
      if(this.orderform.get('product')?.value!='' && this.orderform.get('quantity')?.value!=null){
      this.cart.push({ pid: this.orderform.get('product')?.value, orderedQuantity: this.orderform.get('quantity')?.value });
      }

      //creates array of observable to store product data for each product id
      let observables = [];
      for (let i = 0; i < this.cart.length; i++){
          this.pid = this.cart[i].pid;
          let product_url = `http://localhost:8080/product/products/${this.pid}`;

          observables.push(this.http.get(product_url));
      }

      //wait for all requests to complete before handling the emitted data
      forkJoin(observables).subscribe((products: any[]) => {
          for (let i = 0; i < this.cart.length; i++) {
              let product = products[i];
              this.totalvolume += this.cart[i].orderedQuantity * product.volumePerUnit;
              this.totalweight += this.cart[i].orderedQuantity * product.weightPerUnit;
          }
          const order = {
            volume: this.totalvolume,
            weight: this.totalweight,
            deliveryAddress: this.orderform.get('address')?.value,
            from: this.orderform.get('from')?.value,
            to: this.orderform.get('to')?.value,
            uid: this.userid
          };
          
          console.log(order);
    
          // post request to order table
          this.orderService.submitOrder(order).subscribe(
            response => {
              console.log('Order submitted successfully:', response);
          
              // after order is submitted successfully items data will be sent
              this.orderService.submititems(this.cart).subscribe(
                response => {
                  console.log('Ordered items submitted successfully:', response);
                  // clear the form after submission
                  this.cart = [];
                  this.orderform.get('product')?.setValue('');
                  this.orderform.get('quantity')?.setValue(null);
                  this.orderform.get('from')?.setValue(null);
                  this.orderform.get('to')?.setValue(null);
                  this.orderform.reset({ address: this.orderform.get('address')?.value });
                  window.alert('Success!');
                },
                error => {
                  console.log('Error submitting ordered items:', error);
                }
              );
            },
            error => {
              console.log('Error submitting order:', error);
            }
          );
      });
    }

    addToCart() {
      console.log(this.cart);
      this.cart.push({ pid: this.orderform.get('product')?.value, orderedQuantity: this.orderform.get('quantity')?.value });
      // clear the product type and quantity fields after adding to cart
      this.orderform.get('product')?.setValue('');
      this.orderform.get('quantity')?.setValue(null);
      this.orderform.reset({ address: this.orderform.get('address')?.value, from: this.orderform.get('from')?.value, to: this.orderform.get('to')?.value});  
    }

    // showSuccessNotification() {
    //   const config = new MatSnackBarConfig();
    //   config.verticalPosition = 'top';
    //   config.horizontalPosition = 'start';
    //   this.snackBar.open('Success!', 'Close', {
    //     duration: 2000, // in milliseconds
    //     panelClass: ['success-snackbar'] // custom CSS class for styling
    //   });
    // }
  
}
