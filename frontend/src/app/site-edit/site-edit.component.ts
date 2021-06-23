import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { SitesService } from '../sites.service';
import { Site } from '../site'

@Component({
  selector: 'app-site-edit',
  templateUrl: './site-edit.component.html',
  styleUrls: ['./site-edit.component.css']
})
export class SiteEditComponent implements OnInit {

  site: Site | null = null

  id: String = ""

  url = new FormControl('')

  constructor(private service: SitesService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.id = params.get('id')!
      var site = this.service.getSite(+this.id)
      if (site) {
        this.site = site
        this.url = new FormControl(site.url)
      }
    })
  }

  update(): void {
    this.service.updateSite( {id: +this.id, url: this.url.value, status: "edited" })
    this.router.navigate(['/sites'])
  }

}
