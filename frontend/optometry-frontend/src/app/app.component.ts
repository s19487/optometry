import { Component } from '@angular/core';
import { NavigationStart, Router } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { AuthenticationService } from './services/authentication.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'optometry-frontend';

  showHead: boolean = false;

  constructor(
    private router: Router,
    public authenticationService: AuthenticationService
  ) {
    // router.events.forEach((event) => {
    //   if (event instanceof NavigationStart) {
    //     if (event.url == '/login' || event.url == '/register') {
    //       this.showHead = false;
    //     } else {
    //       this.showHead = true;
    //     }
    //   }
    // });
  }
}
