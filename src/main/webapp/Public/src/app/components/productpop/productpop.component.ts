import { HttpClient } from '@angular/common/http';
import { Component, Inject, Input } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ENDPOINTS } from 'src/app/endpoints/rest.endpoints';

@Component({
  selector: 'app-productpop',
  templateUrl: './productpop.component.html',
  styleUrls: ['./productpop.component.css']
})
export class ProductpopComponent {
// someData: any;
// @Input() someData: any;
  getItem: any;
  constructor(public dialogRef: MatDialogRef<ProductpopComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,private http : HttpClient){
      // console.log("pop"+this.data.someData);
    }
    ngOnInit(): void {
      this.http.get(ENDPOINTS.ITEMGETBYOID+this.data.someData).subscribe(data=>{
        this.getItem = data;
      }
    
    )
  //console.log(this.getItem);
  
  }}
