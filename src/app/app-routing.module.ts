import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

/** Login */
import { LoginComponent } from './components/login/login.component';
/** Home */
import { UserManagementComponent } from './components/user/user-management/user-management.component';
import { UserInsertComponent } from './components/user/user-insert/user-insert.component';
import { UserUpdateComponent } from './components/user/user-update/user-update.component';


const routes: Routes = [
    { path: '', redirectTo: '/login', pathMatch: 'full' },
    { path: 'login', component: LoginComponent },
    /** User */
    { path: 'User/userManagement', component: UserManagementComponent },
    { path: 'User/insert', component: UserInsertComponent },
    { path: 'User/update/:userId', component: UserUpdateComponent },
    
];


@NgModule({
    exports: [RouterModule],
    imports: [RouterModule.forRoot(routes, { onSameUrlNavigation: 'reload', enableTracing: true })],
    declarations: []
})
export class AppRoutingModule {
}
