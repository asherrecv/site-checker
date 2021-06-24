import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SiteAddComponent } from './site-add/site-add.component';
import { SiteEditComponent } from './site-edit/site-edit.component';
import { SitesComponent } from './sites/sites.component';

const routes: Routes = [
  {
    path: 'sites',
    component: SitesComponent
  },
  {
    path: 'sites/add',
    component: SiteAddComponent,
  },
  {
    path: 'sites/:id/edit',
    component: SiteEditComponent,
  },
  { path: '',
    redirectTo: '/sites',
    pathMatch: 'full'
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
