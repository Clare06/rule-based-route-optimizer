import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { AddproductpopComponent } from '../addproductpop/addproductpop.component';


@Component({
  selector: 'app-stock',
  templateUrl: './stock.component.html',
  styleUrls: ['./stock.component.css']
})
export class StockComponent implements OnInit{
products: any;

constructor(private http: HttpClient,private dialog: MatDialog){

}

  ngOnInit(): void {
    const product_url = 'http://localhost:8080/product';
      this.http.get(product_url).subscribe((data: any) => {
      this.products=data;
    });
  }

  openDialog(){
    this.dialog.open(AddproductpopComponent);
  }

  onDelete(pid: number,index: number){
    console.log(pid);
    this.http.delete<void>(`http://localhost:8080/product/products/${pid}`).subscribe(() => {
        if (index !== -1) {
          this.products.splice(index, 1);
        }
      },
      error => console.error(error)
    );
  }
}
