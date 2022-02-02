import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MenuService {

  private baseUrl = 'http://localhost:60320/MLP319/api/menu';
  constructor(private http: HttpClient) { }

  getAllMenuList(): Observable<any>{
    return this.http.get(`${this.baseUrl}/list`);
  }

  getMenuItem(id: number): Observable<any>{
    return this.http.get(`http://localhost:60320/MLP319/api/menu/get/${id}`);
  }

  deleteMenuItemById(id: number): Observable<any>{
    return this.http.delete(`${this.baseUrl}/delete/${id}`,{responseType: 'text'});
  }


  createMenu(menu: Object ):Observable<Object> {
    return this.http.post(`http://localhost:60320/MLP319/api/menu/create`,menu);
  }

  updateMenuItem(id: number,value: any): Observable<Object>{
    return this.http.put(`${this.baseUrl}/update`,value);
  }
}
