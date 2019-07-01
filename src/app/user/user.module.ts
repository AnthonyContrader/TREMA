import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { UserRoutingModule} from './user-routing.module';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import {TeamComponent} from './user-dashboard/team/team.component';
import { TaskComponent } from './user-dashboard/task/task.component';
import { MaterialComponent } from './user-dashboard/material/material.component';

@NgModule({
  declarations: [UserDashboardComponent, TeamComponent, TaskComponent, TeamComponent, MaterialComponent],
  imports: [
    CommonModule,
    FormsModule,
    UserRoutingModule
  ]
})
export class UserModule { }
