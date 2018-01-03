import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { TranslateModule, TranslateLoader } from '@ngx-translate/core';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
import { NgbCarouselModule, NgbAlertModule } from '@ng-bootstrap/ng-bootstrap';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthGuard } from './shared';
import { AuthenticationService } from './service/authentication.service';
import { FormsModule } from '@angular/forms';
import { IsAuthorized } from './directive/is-authorized';
import {LoginComponent} from "./com/login/login.component";
import {LayoutComponent} from "./com/layout/layout.component";
import { HeaderComponent } from './com/layout/components/header/header.component'
import { SidebarComponent } from './com/layout/components/sidebar/sidebar.component'
import {DashboardComponent} from "./com/dashboard/dashboard.component";
import { TimelineComponent } from './com/dashboard/components/timeline/timeline.component';
import { ChatComponent } from './com/dashboard/components/chat/chat.component';
import { NotificationComponent } from './com/dashboard/components/notification/notification.component';
import { StatModule } from './shared'
import {ChartsComponent} from "./com/layout/charts/charts.component";
import {TablesComponent} from "./com/layout/tables/tables.component";
import {RouterModule} from "@angular/router";
import {LayoutRoutingModule} from "./layout/layout-routing.module";


// AoT requires an exported function for factories
export function createTranslateLoader(http: HttpClient) {
    // for development
    // return new TranslateHttpLoader(http, '/start-angular/SB-Admin-BS4-Angular-5/master/dist/assets/i18n/', '.json');
    return new TranslateHttpLoader(http, './assets/i18n/', '.json');
}

@NgModule({
    imports: [
        CommonModule,
        BrowserModule,
        BrowserAnimationsModule,
        HttpClientModule,
        FormsModule,
        RouterModule,
       // StatModule,
      //  NgbCarouselModule,NgbAlertModule,
        TranslateModule.forRoot({
            loader: {
                provide: TranslateLoader,
                useFactory: createTranslateLoader,
                deps: [HttpClient]
            }
        }),
        AppRoutingModule

    ],
    declarations: [AppComponent,LoginComponent,LayoutComponent,HeaderComponent,SidebarComponent,DashboardComponent,
        ChatComponent,TimelineComponent,NotificationComponent,ChartsComponent,TablesComponent,IsAuthorized],
    providers: [AuthGuard,AuthenticationService],
    bootstrap: [AppComponent]
})
export class AppModule {}
