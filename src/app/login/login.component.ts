import {Component, OnInit} from '@angular/core';
import {LoginDTO} from 'src/dto/logindto';
import {NgForm} from '@angular/forms';
import {UserService} from '../../service/user.service';
import {Router} from '@angular/router';
import {UserDTO} from '../../dto/userdto';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginDTO: LoginDTO;

  constructor(private service: UserService, private router: Router) { }

  ngOnInit() {
  }

  login(f: NgForm): void {
    this.loginDTO = new LoginDTO(f.value.username, f.value.password);

    this.service.login(this.loginDTO).subscribe((token: any) => {
      localStorage.setItem('Autoken', JSON.stringify({ authorities: token.id_token }));
      localStorage.setItem('currentUser', JSON.stringify({ authorities: token.id_token }));
      this.service.userLogged(this.loginDTO.username).subscribe((user: UserDTO) => {

        if (user != null) {
          localStorage.setItem('currentUser', JSON.stringify(user));
          console.log(user.authorities.toString());
          if (user.authorities == 'ROLE_USER,ROLE_ADMIN') {
            this.router.navigate(['/admin-dashboard']);
          }
          if (user.authorities == 'ROLE_USER') {
            this.router.navigate(['/user-dashboard']);
          }
        } else {
          alert('Wrong username or password');
        }
      });
    });
  }
}
