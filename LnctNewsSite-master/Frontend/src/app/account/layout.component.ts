import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';




@Component({ templateUrl: 'layout.component.html' })
export class LayoutComponent {
    constructor(
        private router: Router,
       
        private activatedRoute : ActivatedRoute
    ) {
       this.activatedRoute.queryParams
        .subscribe(queryParams => {
        if (queryParams.type === 'login') {
            this.router.navigate(['account/login'])
        } else if(queryParams.type === 'register') {
            this.router.navigate(['account/register'])
        }
      })
    }
}