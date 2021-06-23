import { Component, OnInit } from '@angular/core';
import { SitesService } from "../sites.service";
import { Site } from "../site"

@Component({
  selector: 'app-sites',
  templateUrl: './sites.component.html',
  styleUrls: ['./sites.component.css']
})
export class SitesComponent implements OnInit {

  sites: Site[];

  constructor(private service: SitesService) {
    this.sites = this.service.getSites()
  }

  ngOnInit(): void {
    this.sites = this.service.getSites()
  }

  delete(id: number): void {
    this.service.deleteSite(id);
    this.sites = this.service.getSites();
  }

}
