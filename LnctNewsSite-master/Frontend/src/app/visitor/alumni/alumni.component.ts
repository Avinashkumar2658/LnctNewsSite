import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/service/data/user.service';

@Component({
  selector: 'app-alumni',
  templateUrl: './alumni.component.html',
  styleUrls: ['./alumni.component.css']
})
export class AlumniComponent implements OnInit {
  alumnis : any[] = [];
  responsse_status = 0;
  constructor(private userService : UserService) { }

  ngOnInit(): void {
    this.findAllAlumni();
  }

  findAllAlumni() {
    this.responsse_status = 0;
    this.userService.executeFindAllAlumni().subscribe(
     res => {
        this.alumnis = res;
        for(let i = 0; i< res.length; i++) {
          this.alumnis[i].profilePhoto = 'data:image/jpeg;base64,' + this.alumnis[i].profilePhoto;
        }
        this.responsse_status = 3;
      }
    )
  }

}
