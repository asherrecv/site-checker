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
//  data: {title: 'Add new task'}
  },
  {
    // display the form to add a new task
    path: 'sites/:id/edit',
    component: SiteEditComponent,
 //   data: {title: 'Task edition'}
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
