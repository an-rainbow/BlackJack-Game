import { Injectable } from '@angular/core';
import {Problem } from '../../models/problem.model';
import {PROBLEMS } from '../../models/mock-problems';

@Injectable()
export class DataService {
  problems: Problem[];

  constructor() { }
  
  getProblems(): Problem[]{
    return this.problems = PROBLEMS;  
  }

  getProblem(id:number): Problem {
    return this.problems.find((problem)=> problem.id===id);
  }

  addProblem(problem: Problem) {
    problem.id= this.problems.length + 1;
    this.problems.push(problem);
  }

}
