import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { routerTransition } from '../../router.animations';
import { AuthenticationService } from '../../service/authentication.service';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.scss']
    //animations: [routerTransition()]
})
export class LoginComponent implements OnInit {
    model: any = {};
    loading = false;
    error = '';
    private username:string='';
    private password:string='';

    constructor(
       public router: Router,
       public authenticationService: AuthenticationService
) { }

    ngOnInit() {
        // reset login status
        this.authenticationService.logout();
    }

    getAccount(){
        this.authenticationService.getAccount().subscribe(data => {
            alert(data);
            console.log(data);
            if (data.userName) {
                this.authenticationService.setLoggedUser(data.userName,data.roles);
                // return true to indicate successful login
                this.router.navigate(['/']);
            } else {
                this.error = 'Username or password is incorrect';
                this.loading = false;
            }
        });
    }

    login() {
      //  this.loading = true;
        this.authenticationService.login(this.model.username, this.model.password)
            .subscribe(data => {

                this.authenticationService.getAccount().subscribe(data => {
                    if (data.userName) {
                        this.authenticationService.setLoggedUser(data.userName,data.roles);
                        // return true to indicate successful login
                        this.router.navigate(['/']);
                    } else {
                        this.error = 'Username or password is incorrect';
                        this.loading = false;
                    }
                });

            },error => {
               console.log(error)
                // this.loading = false;
                // this.error = error;

            });
    }

}
