import { ElementRef, Input, OnDestroy } from '@angular/core';
import { ViewEncapsulation } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { ModalService } from 'src/app/service/modal/modal.service';

@Component({
    selector: 'jw-modal', 
    templateUrl: './modal.component.html', 
    styleUrls: ['./modal.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class ModalComponent implements OnInit, OnDestroy  {

  @Input() id: string;
  private element: any;

  constructor(private modalService: ModalService, private el: ElementRef) {
      this.element = el.nativeElement;
  }

  ngOnInit(): void {
      if (!this.id) {
          console.error('modal must have an id');
          return;
      }
      document.body.appendChild(this.element);
      this.modalService.add(this);
  }
  ngOnDestroy(): void {
      this.modalService.remove(this.id);
      this.element.remove();
  }

  open(): void {
      this.element.style.display = 'block';
      document.body.classList.add('jw-modal-open');

  }

  close(): void {
      this.element.style.display = 'none';
      document.body.classList.remove('jw-modal-open');
  }

}
