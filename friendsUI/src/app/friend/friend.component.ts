import { ModalDismissReasons, NgbModal } from "@ng-bootstrap/ng-bootstrap";
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
  closeResult !: string;
  constructor(private friendService: FriendService, private router: Router, private modalService: NgbModal) {
  }
  ngOnInit(): void {
    this.getFriend();
  }
  getFriend(){
    this.friendService.getFriends().subscribe(data => {
      this.friends = data;
    })
  }
  open(content: any) {
    this.modalService.open(content).result.then(
      (result) => {
        this.closeResult = `Closed with: ${result}`;
      },
      (reason) => {
        this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
      }
    );
  }
  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }
}
