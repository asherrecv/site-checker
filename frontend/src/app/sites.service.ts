import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Site } from './site'

@Injectable({
  providedIn: 'root'
})
export class SitesService {

  constructor(private http: HttpClient) { }

  private prefix = "http://localhost:9000"

  getSites(): Observable<Site[]> {
    return this.http.get<Site[]>(`${this.prefix}/sites`)
  }

  getSite(id: number): Observable<Site> {
    return this.http.get<Site>(`${this.prefix}/sites/${id}`)
  }

  addSite(newUrl: string): Observable<unknown> {
    return this.http.post(`${this.prefix}/sites/`, { url: newUrl })
  }

  deleteSite(id: number): Observable<unknown> {
    return this.http.delete(`${this.prefix}/sites/${id}`)
  }

  updateSite(id: number, newUrl: string): Observable<unknown> {
    return this.http.put(`${this.prefix}/sites/${id}`, { url: newUrl })
  }
}
