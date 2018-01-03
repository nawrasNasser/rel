import { Injectable } from '@angular/core';
import { CanActivate } from '@angular/router';
import { Router, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { AuthenticationService } from '../../service/authentication.service';

@Injectable()
export class AuthGuard implements CanActivate {

    constructor(private router: Router,private authService: AuthenticationService)
    {}

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {

        if (this.authService.isLoggedIn()) {
      //  if(1==1){
            // logged in so return true
            return true;
       }

        // not logged in so redirect to login page with the return url and return false
        this.router.navigate(['/login']);
        return false;
    }
}
