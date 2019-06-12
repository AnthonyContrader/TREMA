
import { Injectable } from '@angular/core';
import { UserDto } from 'src/app/dto/userdto';
import { HttpClient, HttpParams } from '@angular/common/http';
import { AbstractService } from './abstractservice';
import { Observable } from 'rxjs';
import { LoginDto } from '../dto/logindto';

@Injectable({
    providedIn: 'root'
  })

export class UserService extends AbstractService<UserDto>{

    login(loginDTO: LoginDto): Observable<UserDto> {
        return this.http.post<any>('http://localhost:8080/User/login', loginDTO);
  }
}