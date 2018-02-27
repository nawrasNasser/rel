import * as _ from 'lodash';

export  class LoginDto{
    token: string;
    refreshToken: string;
    name:string;
    roles:string;


    constructor(dto?:{token: string, refreshToken: string,name:string,roles: string}) {
        if (dto){
            _.assignIn(this,dto);
        }
    }
}
