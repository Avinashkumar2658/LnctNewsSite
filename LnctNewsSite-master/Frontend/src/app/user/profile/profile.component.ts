import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { User } from 'src/app/datautil';
import { ProfileService } from 'src/app/service/data/profile.service';
import { BasicAuthService } from 'src/app/service/http/basic-auth.service';
declare var $: any;
@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  user: User;
  progressInfos: [];
  selectedFiles: FileList;
  base64Data: any;
  retrievedImages: string;
  i = 1;
  @ViewChild("imageName") imageName: ElementRef;
  selectFiles(event): void {
    this.progressInfos = [];
    this.selectedFiles = event.target.files;
  }
  constructor(private profileService : ProfileService, private basicAuthService : BasicAuthService) { 
    this.user = new User(0, '', '', '', '', 5, false, false, null, null, null, null);
    
  }
  
  ngOnInit(): void { 
    $(document).ready(function(){
          $("#selectedFiles").change(function(this: typeof readURL ){
              readURL(this);
          });
      });
      function readURL(input : any) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
      
            reader.onload = function (e): void {
                $('#wizardPicturePreview').attr('src', e.target!.result).fadeIn('slow');
            }
            reader.readAsDataURL(input.files[0]);
        }
      }
    this.executeGetUserByUserId();
  }

  executeGetUserByUserId() {
    this.profileService.executeFindByUserId(this.basicAuthService.getAuthenticatedUserId()).subscribe(
      response => {
        this.user = response;
        this.base64Data = response.profilePhoto;         
          this.retrievedImages = 'data:image/jpeg;base64,' + this.base64Data;
          this.selectedFiles = this.base64Data;
          var blob = this.dataURItoBlob(this.retrievedImages);
          var file = new File([blob], "fileName.jpeg", {
            type: "'image/jpeg'"
          });
          let list = new DataTransfer();
          let files = new File([file], "filename.jpg");
          list.items.add(files);
          let myFileList = list.files;
          this.selectedFiles = myFileList;
      }
    );

  }

  executeUpdateUser() {
    this.i = 0;
    this.profileService.executeUpdateUser(this.user, this.selectedFiles[0]).subscribe(
    ()  =>  {
      this.i = 1;
      }
    );
  }
  profilePhoto(user: User, profilePhoto: any) {
    throw new Error('Method not implemented.');
  }

  onChange(event) {
    var fileName = this.imageName.nativeElement.value
    var idxDot = fileName.lastIndexOf(".") + 1;
    var extFile = fileName.substr(idxDot, fileName.length).toLowerCase();
    if (!(extFile=="jpg" || extFile=="jpeg" || extFile=="png"))
      alert("Only jpg/jpeg and png files are allowed!");
    this.user.profilePhoto = event.srcElement.files;
    this.selectedFiles = event.srcElement.files
  }






  

  dataURItoBlob(dataURI) {

    // convert base64/URLEncoded data component to raw binary data held in a string
    var byteString;
    if (dataURI.split(',')[0].indexOf('base64') >= 0)
        byteString = atob(dataURI.split(',')[1]);
    else
        byteString = unescape(dataURI.split(',')[1]);

    // separate out the mime component
    var mimeString = dataURI.split(',')[0].split(':')[1].split(';')[0];

    // write the bytes of the string to a typed array
    var ia = new Uint8Array(byteString.length);
    for (var i = 0; i < byteString.length; i++) {
        ia[i] = byteString.charCodeAt(i);
    }

    return new Blob([ia], {type:mimeString});
}

}
