import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Task } from '../task';
import { TaskService } from '../task.service';

@Component({
  selector: 'app-create-task',
  templateUrl: './create-task.component.html',
  styleUrls: ['./create-task.component.css']
})
export class CreateTaskComponent implements OnInit {

  task: Task = new Task();

  constructor(private tasksService: TaskService, private router: Router) { }

  ngOnInit(): void {
  }

  saveTask(){
    this.tasksService.createTask(this.task).subscribe(data => {
      console.log(data);
    },
    error => console.log(error));
  }

  goToTaskList() {
    this.router.navigate(['/tasks'])
  }

  onSubmit() {
    console.log(this.task);
    this.saveTask();
    this.goToTaskList(); 
   }

}
