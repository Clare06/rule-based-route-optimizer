import { Component,OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OrderserviceService } from 'src/app/services/orderservice.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Time } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { AuthService } from 'src/app/services/auth.service';

interface Product {
  id: number;
  name: string;
  weight: number;
  volume: number;
  quantity: number;
}

@Component({
  selector: 'app-returnform',
  templateUrl: './returnform.component.html',
  styleUrls: ['./returnform.component.css']
})

export class ReturnformComponent implements OnInit{
  
  orderform: FormGroup;
  userid: any;
  pid!: number;
  products: any;
  product: any;

  constructor(private router: Router,private orderService: OrderserviceService, private http: HttpClient, private fb: FormBuilder,private auth:AuthService){
    this.orderform = this.fb.group({
      product: ['', Validators.required],
      quantity: [null, [Validators.required,Validators.min(1)]],
      reason: ['', Validators.required],
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

      this.orderform.get('address')?.setValue(this.auth.userBranch()); 
    }


    onClick() {

    }
  
    onSubmit() {
      this.pid = this.orderform.get('product')?.value;

    // getting product details for the selected product
    const product_url = `http://localhost:8080/product/products/${this.pid}`;
    this.http.get(product_url).subscribe((data: any) => {
    this.product=data;

    const order = {
      weight: this.product.weightPerUnit*this.orderform.get('quantity')?.value,
      volume: this.product.volumePerUnit*this.orderform.get('quantity')?.value,
      quantity: this.orderform.get('quantity')?.value,
      address: this.orderform.get('address')?.value,
      reason: this.orderform.get('reason')?.value,
      pid: this.pid,
      uid: this.userid,
      from: this.orderform.get('from')?.value,
      to: this.orderform.get('to')?.value
    };
    console.log(order);

      this.orderService.returnOrder(order).subscribe(
        response => {
          console.log('Return request submitted successfully:', response);
          // clear the form after submission
          this.orderform.get('product')?.setValue('');
          this.orderform.get('quantity')?.setValue(null);
          this.orderform.get('reason')?.setValue('');
          this.orderform.get('from')?.setValue(null);
          this.orderform.get('to')?.setValue(null);
          this.orderform.reset({ address: this.orderform.get('address')?.value });
          window.alert('Success!');
        },
        error => {
          console.log('Error submitting order:', error);
        }
      );
    
    });
}
}