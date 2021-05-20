import { AdminDashboardComponent } from './views/admin-dashboard/admin-dashboard.component';
import { EmployeeListComponent } from './views/employee-list/employee-list.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {path:'home',component:EmployeeListComponent},
  {path:'admin',component:AdminDashboardComponent},
  {path:'',redirectTo:'/home',pathMatch:"full"},
  {path:'**',redirectTo:'/home'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
