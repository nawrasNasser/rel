import {Injectable} from '@angular/core';
import {RequestOptions} from '@angular/http';
import {Observable} from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import {HttpClientModule, HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';
import {LoginDto} from '../dto/login.dto';
import {LoggedUser} from '../com/login/logged.user.class';




@Injectable()
export class AuthenticationService {
    private authUrl = "auth/login";
    private accountUrl = "api/account";
    public headers = new HttpHeaders({"Content-Type": "application/x-www-form-urlencoded","Accept": "application/json, text/plain, */*,application/x-www-form-urlencoded","responseType":"text"});
    private loggedUser:LoggedUser;

    constructor(private http: HttpClient) {
    }

    login(username: string, password: string): Observable<any> {

        let body = `username=`+username+`&password=`+password;

        return this.http.post(this.authUrl,body, {headers: this.headers,responseType: 'text'});
    }

    getAccount(): Observable<any> {

        return this.http.post(this.accountUrl,{}, {responseType: 'json'});
    }

getCurrentUser():LoggedUser{
        return this.loggedUser;
}

    isLoggedIn(): boolean {
        if(this.loggedUser!=null){
            return this.loggedUser.name && this.loggedUser.name.length > 0;
        }
        return false;
    }


    logout(): void {
        // clear token remove user from local storage to log user out
        this.loggedUser=null;
    }

    setLoggedUser(name:string,roles:string[]){
        this.loggedUser = new LoggedUser();
        this.loggedUser.name=name;
        this.loggedUser.roles=roles;

    }
}
