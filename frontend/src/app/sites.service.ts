import { Injectable } from '@angular/core';
import { Site } from './site'

@Injectable({
  providedIn: 'root'
})
export class SitesService {

  constructor() { }

  sites: Site[] = [
    {id: 0, url: "aooble", status: "false"},
    {id: 1, url: "booble", status: "false"},
    {id: 2, url: "booble", status: "false"}
  ]

  getSites(): Site[] {
    return this.sites
  }

  getSite(id: number): Site | undefined {
    return this.sites.find(site => { return site.id == id} )
  }

  addSite(newUrl: string) {
    var newId = Math.max(...this.sites.map(site => {return site.id})) + 1
    this.sites = [...this.sites, {id: newId, url: newUrl, status: "added"} ]
  }

  deleteSite(id: number) {
    this.sites = this.sites.filter(site => { return site.id != id })
  }

  updateSite(updatedSite: Site) {
    this.sites = this.sites.map(site => {
      if (updatedSite.id != site.id) {
        return site
      } else {
        return updatedSite
      }
    })
  }
}
