import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { Router, RouterModule } from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgxChartsModule } from '@swimlane/ngx-charts';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component'
import { HomeComponent } from './components/home/home.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { SettingsComponent } from './components/settings/settings.component';
import { HomebodyComponent } from './components/homebody/homebody.component';
import { DialogComponent } from './components/dialog/dialog.component';
import { ReturnreqComponent } from './components/returnreq/returnreq.component';
import { RorderComponent } from './components/rorder/rorder.component';
import { MatDialogModule } from '@angular/material/dialog';
import { OrderComponent } from './components/order/order.component';
import { RouteComponent } from './components/route/route.component';
import { HistoryComponent } from './components/history/history.component';
import { ProductpopComponent } from './components/productpop/productpop.component';
import { PopvehicleComponent } from './components/popvehicle/popvehicle.component';
import { ReturnformComponent } from './components/returnform/returnform.component';
import { OrderformComponent } from './components/orderform/orderform.component';
import { StockComponent } from './components/stock/stock.component';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { AddproductpopComponent } from './components/addproductpop/addproductpop.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatSnackBarModule,MatSnackBarConfig } from '@angular/material/snack-bar';
import { WarebodyComponent } from './components/warebody/warebody.component';
import { NgChartsModule } from 'ng2-charts';
// import { VehicleComponent } from './components/vehicle/vehicle.component';
import { WaresettingComponent } from './components/waresetting/waresetting.component';

import { CreateVehicleComponent } from "./components/create-vehicle/create-vehicle.component";
import { UpdateVehicleComponent } from "./components/update-vehicle/update-vehicle.component";
import { VehicleDetailsComponent } from "./components/vehicle-details/vehicle-details.component";
import { VehicleListComponent } from "./components/vehicle-list/vehicle-list.component";
import { OutlethomeComponent } from './components/outlethome/outlethome.component';
import { AdminhomeComponent } from './components/adminhome/adminhome.component';
import { DriverhomeComponent } from './components/driverhome/driverhome.component';
import { UserComponent } from './components/user/user.component';
import { OrderpopupComponent } from './components/orderpopup/orderpopup.component';
import {MatCardModule} from '@angular/material/card';
import { HttpInterceptorService } from './services/http-interceptor.service';
import { HttpInterceptorRecieverService } from './services/http-interceptor-reciever.service';





@NgModule({
    declarations: [
        AppComponent,
        LoginComponent,
        HomeComponent,
        SidebarComponent,
        SettingsComponent,
        HomebodyComponent,
        DialogComponent,
        ReturnreqComponent,
        RorderComponent,
        OrderComponent,
        RouteComponent,
        HistoryComponent,
        ProductpopComponent,
        PopvehicleComponent,
        ReturnformComponent,
        OrderformComponent,
        StockComponent,
        AddproductpopComponent,
        PopvehicleComponent,
        WarebodyComponent,
        WaresettingComponent,
        CreateVehicleComponent,
        UpdateVehicleComponent,
        VehicleDetailsComponent,
        VehicleListComponent,
        OutlethomeComponent,
        AdminhomeComponent,
        DriverhomeComponent,
        UserComponent,
        OrderpopupComponent,

    ],
    providers: [
        MatSnackBarConfig,
        {
          provide : HTTP_INTERCEPTORS,
          useClass: HttpInterceptorService,
          multi   : true,
        },
        {
          provide : HTTP_INTERCEPTORS,
          useClass: HttpInterceptorRecieverService,
          multi   : true,
        }

    ],
    bootstrap: [AppComponent],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
        HttpClientModule,
        BrowserAnimationsModule,
        RouterModule,
        MatDialogModule,
        ReactiveFormsModule,
        MatInputModule,
        MatButtonModule,
        MatFormFieldModule,
        MatIconModule,
        MatSnackBarModule,
        MatDialogModule,
        NgxChartsModule,
        NgChartsModule,
        ReactiveFormsModule,
        MatCardModule
    ]
})
export class AppModule {
  constructor(private router: Router) {}
  isDash(): boolean {
    return this.router.url === "/home";
  }
}
