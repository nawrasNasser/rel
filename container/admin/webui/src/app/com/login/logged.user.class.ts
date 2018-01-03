
export  class LoggedUser{
    roles: string[];
    name: string;

    constructor() {
    }

    hasRole(role:string){
        for (let entry of  this.roles) {
           if(entry===role){
               return true;
           }
        }
        return false;
    }
}
