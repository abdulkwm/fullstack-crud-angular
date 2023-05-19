import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Friend } from '../friend';

@Injectable({
  providedIn: 'root'
})
export class FriendService {
  private baseUrl = "http://localhost:9001/friends";

  constructor(private httpClient : HttpClient) { }
  getFriends():Observable<Friend[]> {
    return this.httpClient.get<Friend[]>(`${this.baseUrl}`);
  }
}
