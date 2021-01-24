import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Task } from '../task';
import { TaskService } from '../task.service';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent implements OnInit {

  tasks: Task[];
  constructor(private tasksService: TaskService, private router: Router) { }

  ngOnInit(): void {
    this.getTasks();
  }

  private getTasks() {
    this.tasksService.getTaskList().subscribe(data => {
      this.tasks = data;
    })
  }

  updateTask(id: number) {
    this.router.navigate(['update-task', id]);
  }

  deleteTask(id: number) {
    this.tasksService.deleteTask(id).subscribe(data => {
      console.log(data);
      this.getTasks();
    });

  }

}
