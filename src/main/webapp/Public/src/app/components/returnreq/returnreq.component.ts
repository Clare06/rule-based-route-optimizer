import { HttpClient } from '@angular/common/http';
import { Component, OnInit , Input} from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { ActivatedRoute } from '@angular/router';
import { ENDPOINTS } from 'src/app/endpoints/rest.endpoints';
import { PopvehicleComponent } from '../popvehicle/popvehicle.component';

@Component({
  selector: 'app-returnreq',
  templateUrl: './returnreq.component.html',
  styleUrls: ['./returnreq.component.css']
})
export class ReturnreqComponent implements OnInit {
  getReturn: any;
  private curReq: number[] = [];
  status: boolean | true =true;
  // @Input() item='';
  curOrder: number[]=[];
  constructor(private http:HttpClient,private route: ActivatedRoute,private dialog: MatDialog,){}

  ngOnInit(): void {
      this.http.get(ENDPOINTS.GETRETURN).subscribe(data => {
        this.getReturn=data;
      });
      this.route.queryParams.subscribe((params)=>{
        this.curOrder=params['variable'].map(Number);
      });
      // console.log(this.curOrder);
  }
  public add(id: number ){
    for (var index in this.curReq) {
      if (this.curReq[index] == id) {
        
        this.curReq.splice(parseInt(index), 1);
        this.status=!this.status;

        // console.log(this.status);
        console.log(this.curReq);
      }
    }

    if(this.status){

    this.curReq.push(id);
    // console.log(this.curReq);
    // console.log(this.status);
    }
    this.status=true;
}
  public onSubmit(){
    console.log(this.curOrder);
    console.log(this.curReq);
    const dialogConfig = new MatDialogConfig();

    dialogConfig.data = {
      someData: this.curOrder,
      someReq: this.curReq
    };
    dialogConfig.width='100%';
    
    const dialogRef = this.dialog.open(PopvehicleComponent,dialogConfig,
      );

    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
    });
  }



  public clear(){
    this.curReq=[];
    console.log(this.curReq);
  }
  public active(id: number): boolean {

    for(var index in this.curReq){
      if(this.curReq[index]==id){
        return false;
      }
    }


    return true;
  }
}
