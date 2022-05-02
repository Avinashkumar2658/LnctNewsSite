import { Component, OnInit } from '@angular/core';
import { Question } from 'src/app/datautil';
import { QuestionService } from 'src/app/service/data/question.service';

@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.css']
})
export class QuestionComponent implements OnInit {
questions : Question[] = [];
responsse_status = 0;
  constructor(
    private questionService : QuestionService
  ) { }

  ngOnInit(): void {
    this.getAllQuestion();
  }

  getAllQuestion() {
    this.responsse_status = 0;
    this.questionService.executeFindAllQuestion().subscribe(
      res => {
        this.questions = res;
        this.responsse_status = 3;
      }
    );
  }

}
