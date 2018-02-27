import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import  {LoginComponent} from "./com/login/login.component";
import { AuthGuard } from './shared/guard/auth.guard';
import { LayoutComponent } from "./com/layout/layout.component";
import { DashboardComponent } from "./com/dashboard/dashboard.component";
import {ChartsComponent} from "./com/layout/charts/charts.component";
import {TablesComponent} from "./com/layout/tables/tables.component";
import {LayoutRoutingModule} from "./layout/layout-routing.module";
//import {SideBarRoutingModule} from "./com/dashboard/dashboard-routing.module";

const routes: Routes = [
  //  { path: '', component:LayoutComponent, canActivate: [AuthGuard]
        // ,children: [
        // // {path: 'ff',component: SidebarComponent},
        // {path: 'charts',component: ChartsComponent},
        // {path: 'tables',component: TablesComponent}
        // ]
  //  },
    { path: 'login', component: LoginComponent },
    { path: 'signup', loadChildren: './signup/signup.module#SignupModule' },
    { path: 'error', loadChildren: './server-error/server-error.module#ServerErrorModule' },
    { path: 'access-denied', loadChildren: './access-denied/access-denied.module#AccessDeniedModule' },
    { path: 'not-found', loadChildren: './not-found/not-found.module#NotFoundModule' },
    { path: '**', redirectTo: 'not-found' }
];

@NgModule({
    imports: [RouterModule.forRoot(routes),LayoutRoutingModule],
    exports: [RouterModule]
})
export class AppRoutingModule {}
