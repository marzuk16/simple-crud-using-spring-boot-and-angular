import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users: User[];
  
  constructor(
    public userService: UserService,
    public router: Router
  ) { }

  ngOnInit(): void {

    this.getData();
  }

  public getData() {
    
    this.userService.getUsersList().subscribe(data => {
      //console.log("data: ", data);
      //console.log("typeof: ", typeof data);
      this.users = data;
    });
  }

  updateUser(id: number){
    this.router.navigate(['update-user', id]);
  }

  deleteUser(id: number){
    this.userService.deleteUser(id).subscribe(res => {
      console.log(res);
      this.getData();
    });
  }
}
