import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SiteAddComponent } from './site-add/site-add.component';
import { SiteEditComponent } from './site-edit/site-edit.component';
import { SitesComponent } from './sites/sites.component';


@NgModule({
  declarations: [
    AppComponent,
    SiteAddComponent,
    SiteEditComponent,
    SitesComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
