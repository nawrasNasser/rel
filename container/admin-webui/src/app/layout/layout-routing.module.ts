// import { NgModule } from '@angular/core';
// import { Routes, RouterModule } from '@angular/router';
// import { LayoutComponent } from '../com/layout/layout.component';
//
// const routes: Routes = [
//     {
//         path: '',
//         component: LayoutComponent,
//         children: [
//             { path: '', redirectTo: 'dashboard' },
//             { path: 'dashboard', loadChildren: './dashboard/dashboard.module#DashboardModule' },
//             { path: 'charts', loadChildren: './charts/charts.module#ChartsModule' },
//             { path: 'tables', loadChildren: './tables/tables.module#TablesModule' },
//             { path: 'forms', loadChildren: './form/form.module#FormModule' },
//             { path: 'bs-element', loadChildren: './bs-element/bs-element.module#BsElementModule' },
//             { path: 'grid', loadChildren: './grid/grid.module#GridModule' },
//             { path: 'components', loadChildren: './bs-component/bs-component.module#BsComponentModule' },
//             { path: 'blank-page', loadChildren: './blank-page/blank-page.module#BlankPageModule' }
//         ]
//     }
// ];
//
// @NgModule({
//     imports: [RouterModule.forChild(routes)],
//     exports: [RouterModule]
// })
// export class LayoutRoutingModule {}

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LayoutComponent } from '../com/layout/layout.component';
import {AuthGuard} from "../shared/guard/auth.guard";
import {ChartsComponent} from "../com/layout/charts/charts.component";
import {TablesComponent} from "../com/layout/tables/tables.component";
import {DashboardComponent} from "../com/dashboard/dashboard.component";
import {SidebarComponent} from "../com/layout/components/sidebar/sidebar.component";
//import {SideBarRoutingModule} from "../com/dashboard/dashboard-routing.module";

const routes: Routes = [
    { path: '', component:LayoutComponent , canActivate: [AuthGuard]
        ,children: [
         {path: '',component: DashboardComponent},
        {path: 'charts',component: ChartsComponent},
        {path: 'tables',component: TablesComponent}
    ]
    }
];

@NgModule({
    imports: [ RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class LayoutRoutingModule {}
