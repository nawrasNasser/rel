import { Component, OnInit } from '@angular/core';
import {routerTransition} from "../../../../router.animations";
import {TranslateService} from "@ngx-translate/core";
import {Router} from "@angular/router";
import {AuthenticationService} from "../../../../service/authentication.service";

@Component({
    selector: 'app-sidebar',
    templateUrl: './sidebar.component.html',
    styleUrls: ['./sidebar.component.scss']

})
export class SidebarComponent {
    isActive: boolean = false;
    showMenu: string = '';

    eventCalled() {
        this.isActive = !this.isActive;
    }

    addExpandClass(element: any) {
        if (element === this.showMenu) {
            this.showMenu = '0';
        } else {
            this.showMenu = element;
        }
    }

    constructor(private translate: TranslateService, public router: Router,public authenticationService: AuthenticationService) {

        this.translate.addLangs(['en', 'fr', 'ur', 'es', 'it', 'fa', 'de']);
        this.translate.setDefaultLang('en');
        const browserLang = this.translate.getBrowserLang();
        this.translate.use(browserLang.match(/en|fr|ur|es|it|fa|de/) ? browserLang : 'en');

        this.router.events.subscribe(val => {
            // if (
            //     val instanceof NavigationEnd &&
            //     window.innerWidth <= 992 &&
            //     this.isToggled()
            // ) {
            //     this.toggleSidebar();
            // }
        });
    }
}
