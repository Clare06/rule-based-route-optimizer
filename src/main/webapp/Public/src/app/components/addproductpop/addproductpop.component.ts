import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { Location } from '@angular/common';

@Component({
  selector: 'app-addproductpop',
  templateUrl: './addproductpop.component.html',
  styleUrls: ['./addproductpop.component.css']
})
export class AddproductpopComponent implements OnInit{
  productForm: FormGroup;

  constructor(private dialogRef: MatDialogRef<AddproductpopComponent>,private http: HttpClient,private fb:FormBuilder,private location: Location) {
    this.productForm = this.fb.group({
      name: [''],
      weight: [null],
      volume: [null],
      quantity: [null]
    });
  }

  ngOnInit(): void {

  }

  close() {
    this.dialogRef.close();
  }

  //adding new product to the stock
  onClick() {
    const product_url = 'http://localhost:8080/product';
    const product = {
      productName: this.productForm.get('name')?.value,
      weightPerUnit: this.productForm.get('weight')?.value,
      volumePerUnit: this.productForm.get('volume')?.value,
      availableQuantity: this.productForm.get('quantity')?.value,
    };
    this.http.post(product_url, product).subscribe(response => {
      console.log(response);
    });
    this.dialogRef.close();

    this.location.go(this.location.path());
    window.location.reload();
  }
}
