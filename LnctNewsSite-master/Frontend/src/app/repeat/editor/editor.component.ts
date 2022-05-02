import { Component, OnInit, Input, EventEmitter } from '@angular/core';
import { ToolbarService, LinkService, ImageService, HtmlEditorService, TableService } from '@syncfusion/ej2-angular-richtexteditor';
import { Answer } from 'src/app/datautil';
import { AnswerService } from 'src/app/service/data/answer.service';
import { BasicAuthService } from 'src/app/service/http/basic-auth.service';
export function getBaseUrl() {
  return document.getElementsByTagName('base')[0].href;
}
@Component({
  selector: 'app-editor',
  templateUrl: './editor.component.html',
  styleUrls: ['./editor.component.css'],
  providers: [ToolbarService, LinkService, ImageService, HtmlEditorService, TableService,
    { provide: 'BASE_URL', useFactory: getBaseUrl }

  
  ],  
})

export class EditorComponent implements OnInit {
  answer : Answer;
  answer1 
  @Input() questionId : number
  constructor(private ansewrService : AnswerService,public  basicAuthService : BasicAuthService) {
    this.answer = new Answer(0, '' , new Date(), basicAuthService.getAuthenticatedUserId(), 0)
   
   }
   saveAnswer(form) {
     
    this.answer.questionId = this.questionId;
    this.ansewrService.executeSaveAnswer(this.answer).subscribe(
      () => {
        form.reset();
        window.location.reload();
      }
    );
  }

  ngOnInit(): void {
  
  }
  value : string
  public tools: object = {
    items: [
           'Bold', 'Italic',  '|',
            'Undo', 'Redo', '|',
            'Alignments', '|', 'OrderedList', 'UnorderedList', '|',
            '|', 'CreateLink',
           'Image',  '|', 'FullScreen']
   };

   fromRTE
   public imageSettings: Object;
  
  onSubmit(rteForm) {
    const quesionHtml = new DOMParser().parseFromString(this.value, 'text/html')
  }
  
  rteCreated() {
   
  }
}


