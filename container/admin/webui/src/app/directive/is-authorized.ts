
import { Directive, Input, TemplateRef, ViewContainerRef } from '@angular/core';
import { AuthenticationService } from '../service/authentication.service';

@Directive({
    selector: '[roles]',
    inputs: ['roles']
})

export class IsAuthorized {

    constructor(private _templateRef: TemplateRef<any>,
                private _viewContainer: ViewContainerRef,
                private authenticationService: AuthenticationService) {

    }

    @Input() set roles(allowedRoles: Array<string>) {
        let shouldShow: boolean = false;

        for(let role of allowedRoles){
            if(this.authenticationService.getCurrentUser().hasRole(role)){
                shouldShow = true;
                break;
            }
        }

        if (shouldShow) {
            this._viewContainer.createEmbeddedView(this._templateRef);
        } else {
            this._viewContainer.clear();
        }
    }

}
