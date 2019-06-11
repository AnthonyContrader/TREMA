import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

/** Import modules */
import { AppRoutingModule } from './app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

/** ========= Import component ============ */
import { AppComponent } from './app.component';

/** Shared component */
import { HeaderComponent } from './components/share/header/header.component';
import { FooterComponent } from './components/share/footer/footer.component';
import { SidebarAdminComponent } from './components/share/sidebar-admin/sidebar-admin.component';
import { SidebarBoComponent } from './components/share/sidebar-bo/sidebar-bo.component';
import { SidebarResourceComponent } from './components/share/sidebar-resource/sidebar-resource.component';

/** Home component */
import { LoginComponent } from './components/login/login.component';


/** User */
import { UserManagementComponent } from './components/user/user-management/user-management.component';
import { UserUpdateComponent } from './components/user/user-update/user-update.component';
import { UserInsertComponent } from './components/user/user-insert/user-insert.component';

/** Services */
import { LoginService } from './services/login.service';
import {UserService} from './services/user.service';



@NgModule({
    declarations: [
        AppComponent,
        HeaderComponent,
        FooterComponent,
        LoginComponent,
        SidebarAdminComponent,
        SidebarBoComponent,
        SidebarResourceComponent,
        UserManagementComponent,
        UserUpdateComponent,
        UserInsertComponent,
        
    ],
    imports: [
        BrowserModule,
        FormsModule,
        HttpClientModule,
        AppRoutingModule,
        ReactiveFormsModule
    ],
    providers: [
        LoginService,
        UserService
    ],
    bootstrap: [AppComponent]
})
export class AppModule { }
