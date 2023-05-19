import { Friend } from "./../friend";
import { Component, OnInit } from '@angular/core';
import { FriendService } from "../service/friend.service";
import { Router } from "@angular/router";

@Component({
  selector: 'app-friend',
  templateUrl: './friend.component.html',
  styleUrls: ['./friend.component.css']
})
export class FriendComponent implements OnInit{
  friends !: Friend[];
  constructor(private friendService : FriendService, private router : Router  ) {
  }
  ngOnInit(): void {
    this.getFriend();
  }
  getFriend(){
    this.friendService.getFriends().subscribe(data => {
      this.friends = data;
    })
  }

}
