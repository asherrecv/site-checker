import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { SitesService } from '../sites.service';

@Component({
  selector: 'app-site-add',
  templateUrl: './site-add.component.html',
  styleUrls: ['./site-add.component.css']
})
export class SiteAddComponent implements OnInit {

  url = new FormControl('');

  constructor(private service: SitesService, private router: Router) { }

  ngOnInit(): void {
  }

  create(): void {
    this.service.addSite(this.url.value).subscribe(x => {
      this.router.navigate(["/sites"])
    })
  }

}
