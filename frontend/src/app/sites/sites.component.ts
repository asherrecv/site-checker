import { Component, OnDestroy, OnInit } from '@angular/core';
import { SitesService } from "../sites.service";
import { Site } from "../site"
import { Subscription, timer } from 'rxjs';
import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-sites',
  templateUrl: './sites.component.html',
  styleUrls: ['./sites.component.css']
})
export class SitesComponent implements OnInit, OnDestroy {

  sites: Site[] = [];

  subscription: Subscription | null = null

  constructor(private service: SitesService) {
     this.service.getSites().subscribe(resp => {
        this.sites = resp
      })
  }

  ngOnInit(): void {
    this.subscription = timer(0, 5000)
      .pipe(
        switchMap(() => this.service.getSites())
      ).subscribe(resp => this.sites = resp);

    this.service.getSites().subscribe(resp => {
      this.sites = resp
    })
  }

  ngOnDestroy(): void {
    this.subscription!.unsubscribe();
  }

  delete(id: number): void {
    this.service.deleteSite(id).subscribe(x => {
      this.service.getSites().subscribe(resp => {
        this.sites = resp
      })
    })
  }

}
