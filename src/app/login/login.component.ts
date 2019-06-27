import { Component, OnInit } from '@angular/core';
import { LoginDTO } from 'src/dto/logindto';
import { NgForm } from '@angular/forms';
import { UserService } from '../../service/user.service';
import { Router } from '@angular/router';
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
      localStorage.setItem('currentUser', JSON.stringify({ usertype : token.id_token }));

      this.service.userLogged(this.loginDTO.username).subscribe((user: UserDTO) => {

      if (user != null) {
        localStorage.setItem('currentUser', JSON.stringify(user));
        console.log(user.usertype);

        switch (user.usertype) {
          case 0:  this.router.navigate(['/admin-dashboard']);
                   break;
          case 1:  this.router.navigate(['/user-dashboard']);
                   break;
          default:  this.router.navigate(['/user-dashboard']);

        }
      }
  });
  });
}
}
