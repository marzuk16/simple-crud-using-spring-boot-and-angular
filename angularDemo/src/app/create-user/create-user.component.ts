import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit {
  user: User = new User();

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
  }

  saveUser(){
    this.userService.createUser(this.user).subscribe(res => {
      console.log(res);
      this.goToUserList();    
    },
    error => console.log(error)
    );
  }
  goToUserList(){
    console.log("redirect users");
    
    this.router.navigate(["/users"]);
  }
  onSubmit(){
    //alert("working....")
    console.log("onSubmit: ", this.user);
    this.saveUser();
  }

}
