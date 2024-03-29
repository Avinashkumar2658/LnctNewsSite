import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ModalComponent } from '../account/modal/modal.component';
import { ModalService } from '../service/modal/modal.service';



@NgModule({
  declarations: [ModalComponent],
  imports: [ CommonModule ],
  exports: [ModalComponent],
  providers: [ModalService]
})
export class ModalModule { }
