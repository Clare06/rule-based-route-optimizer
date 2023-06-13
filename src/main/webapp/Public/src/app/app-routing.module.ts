import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HistoryComponent } from './components/history/history.component';
import { HomeComponent } from './components/home/home.component';
import { HomebodyComponent } from './components/homebody/homebody.component';
import { LoginComponent } from './components/login/login.component';
import { OrderComponent } from './components/order/order.component';
import { OrderformComponent } from './components/orderform/orderform.component';
import { ReturnformComponent } from './components/returnform/returnform.component';
import { ReturnreqComponent } from './components/returnreq/returnreq.component';
import { RorderComponent } from './components/rorder/rorder.component';
import { RouteComponent } from './components/route/route.component';
import { SettingsComponent } from './components/settings/settings.component';
import { StockComponent } from './components/stock/stock.component';
// import { VehicleComponent } from './components/vehicle/vehicle.component';
import { WarebodyComponent } from './components/warebody/warebody.component';
import { WaresettingComponent } from './components/waresetting/waresetting.component';
import { AuthService } from './services/auth.service';
import { AuthguardService} from './services/authguard.service';
import { UpdateVehicleComponent } from "./components/update-vehicle/update-vehicle.component";
import { VehicleDetailsComponent } from "./components/vehicle-details/vehicle-details.component";
import { VehicleListComponent } from "./components/vehicle-list/vehicle-list.component";
import { CreateVehicleComponent } from './components/create-vehicle/create-vehicle.component';
import { OutlethomeComponent } from './components/outlethome/outlethome.component';
import { AdminhomeComponent } from './components/adminhome/adminhome.component';
import { DriverhomeComponent } from './components/driverhome/driverhome.component';
import { UserComponent } from './components/user/user.component';
import { AdminService } from './services/admin.service';
// import { WarebodyComponent } from "./components/warebody/warebody.component";


// const outlet= new AuthoutletService;
const role=new AuthService;

const routes: Routes = [

  {path:"login",component:LoginComponent},
  {path:"",component:HomeComponent,canActivate: [AuthguardService],
   children:[
  {path:"home",component:HomebodyComponent,canActivate: [AuthguardService],
    children:[
      {path:"",component:role.isWarehouse() ? WarebodyComponent:role.isOutlet()? OutlethomeComponent:role.isAdmin()? AdminhomeComponent:role.isDriver()? DriverhomeComponent: LoginComponent,canActivate: [AuthguardService]}
    ]},
  {path:"settings",component:SettingsComponent,canActivate: [AuthguardService],
    children:[
      {path:"",component:WaresettingComponent,canActivate: [AuthguardService]}
    ]},
  {path:"vehicle",component:VehicleListComponent,canActivate: [AuthguardService]},
  {path:"createvehicle",component:CreateVehicleComponent,canActivate: [AuthguardService]},
  {path:"updatevehicle/:id",component:UpdateVehicleComponent,canActivate: [AuthguardService]},
  {path:"vehiclelist/:id",component:VehicleDetailsComponent,canActivate: [AuthguardService]},
  {path:"route",component:RouteComponent,canActivate: [AuthguardService]},
  {path:"user",component:UserComponent,canActivate:[AuthguardService,AdminService]},
  {path:"stock",component:StockComponent,canActivate: [AuthguardService]},
  {path:"history",component:HistoryComponent,canActivate: [AuthguardService]},
  //  {path:"history",component:isOutlet ? HistoryComponent : isWarehouse ? StockComponent : LoginComponent,canActivate: [AuthguardService]},
  {path:"order",component:OrderComponent,canActivate: [AuthguardService],
    children:[
      {path:"returnreq",component:role.isWarehouse() ? ReturnreqComponent: role.isOutlet()? ReturnformComponent : LoginComponent,canActivate: [AuthguardService]},
      {path:"",component:role.isOutlet() ? OrderformComponent: role.isWarehouse() ? RorderComponent  : LoginComponent,canActivate: [AuthguardService]},
      // {path:"",component:HistoryComponent,canActivate: [AuthguardService,AuthoutletService]},
    ]}
   ]},

 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
