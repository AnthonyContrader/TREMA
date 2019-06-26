import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { UserRoutingModule} from "./user-routing.module";
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { DipendentiComponent } from './user-dashboard/dipendenti/dipendenti.component';
import { MaterialComponent } from './user-dashboard/material/material.component';
import { TaskComponent } from './user-dashboard/task/task.component';

@NgModule({
  declarations: [UserDashboardComponent, DipendentiComponent, MaterialComponent, TaskComponent],
  imports: [
    CommonModule,
    FormsModule,
    UserRoutingModule
  ]
})
export class UserModule { }
