import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { ENDPOINTS } from 'src/app/endpoints/rest.endpoints';
import { AuthService } from 'src/app/services/auth.service';


interface ChartData {
  [key: string]: number;
}


@Component({
  selector: 'app-outlethome',
  templateUrl: './outlethome.component.html',
  styleUrls: ['./outlethome.component.css']
})
export class OutlethomeComponent {
  uid: any;
  listbyid: any;
  retlist: any;

  data: any;

  public ChartLabels: any;
  public ChartData: any;
  public ChartOptions: any = {
  responsive: true,
  maintainAspectRatio: false,
  scales: {
    x: {
      barThickness: 20, // Adjust the width of the bars
    },
    y: {
      beginAtZero: true,
      ticks: {
        precision: 0,
        stepSize: 1,
      }
    }
  }
};
  userid: any ;

  constructor(private authService: AuthService,private http:HttpClient){

  }
  ngOnInit(): void {
    this.uid=this.authService.userID();
    this.http.get(ENDPOINTS.LISTBYUID+this.uid).subscribe(data =>{
        this.listbyid=data;
    })
    this.http.get(ENDPOINTS.RETLISTBYUID+this.uid).subscribe(data =>{
        this.retlist=data;
    })

    // Get the current year and month
  const currentDate = new Date();
  const currentYear = currentDate.getFullYear();
  const currentMonth = currentDate.getMonth() + 1;

  // Create an array of months up to the current month of the current year
  const monthsInYear = Array.from({ length: currentMonth }, (_, monthIndex) => {
    const month = monthIndex + 1;
    return `${currentYear}-${month < 10 ? '0' : ''}${month}`;
  });

  this.http.get<ChartData>(`http://localhost:8080/order/grouped_by_month/${this.uid}`)
    .subscribe(data => {
      const chartData: number[] = [];

      for (const month of monthsInYear) {
        if (data.hasOwnProperty(month)) {
          chartData.push(data[month]);
        } else {
          chartData.push(0);
        }
      }

      this.ChartData = chartData;
      this.ChartLabels = monthsInYear;
    });
    }
  }
