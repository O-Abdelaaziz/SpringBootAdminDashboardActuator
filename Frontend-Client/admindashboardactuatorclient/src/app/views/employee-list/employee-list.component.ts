import { Component, OnInit } from '@angular/core';
import {EmployeeService} from "../../data/services/employee.service";
import {Employee} from "../../data/schema/employee";
import {HttpErrorResponse} from "@angular/common/http";
import Swal from 'sweetalert2'

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.scss']
})
export class EmployeeListComponent implements OnInit {
  public employeeList: Employee[]=[];

  public size:number=1;
  public pageNumber:number=0;
  public pageSize:number = 8;
  public totalElements:number=0;
  public totalPages:number=0;


  constructor(private _employeeService: EmployeeService) {}

  ngOnInit() {
    this.getEmployees();
  }

  public onGenerateEmployees(size:number): void {
    this._employeeService.generateEmployees(size).subscribe(
      (response) => {
        this.getEmployees();
      },
      (error: HttpErrorResponse) => {
        console.error(error);
      }
    );
  }

  public getEmployees(): void {
    this._employeeService.getEmployees(this.pageNumber,this.pageSize).subscribe(
      (response) => {
        console.log(response);
        this.employeeList=response.content;
        this.pageNumber=response.number +1;
        this.totalElements=response.totalElements;
        this.totalPages=response.totalPages;
      },
      (error: HttpErrorResponse) => {
        console.error(error);
      }
    );
  }

  // public searchEmployees(key: string): void {
  //   console.log('Searching employees...');
  //   const results: Employee[] = [];
  //   for (const employee of this.employeeList) {
  //     if (employee.name.toLowerCase().indexOf(key.toLowerCase()) !== -1
  //       || employee.email.toLowerCase().indexOf(key.toLowerCase()) !== -1 ||
  //       employee.phone.toLowerCase().indexOf(key.toLowerCase()) !== -1 ||
  //       employee.jobTitle.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
  //       results.push(employee);
  //     }
  //   }
  //   this.employeeList = results;
  //   if (results.length === 0 || !key) {
  //     this.getEmployees();
  //   }
  // }

  public onDeleteEmployee(employeeId: number,name:string): void {
    Swal.fire({
      title: 'Are you sure?',
      text: 'You will delete this employee '+name ,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, keep it'
    }).then((result) => {
      if (result.isConfirmed) {
        this._employeeService.deleteEmployee(employeeId).subscribe(
          (response: Employee) => {
            console.log(`Employee deleted`);
            // this.employee = response;
            this.getEmployees();
          },
          (error: HttpErrorResponse) => {
            console.error(error);
          }
        );
        Swal.fire(
          'Deleted!',
          'Your employee has been deleted.',
          'success'
        )
      // For more information about handling dismissals please visit
      // https://sweetalert2.github.io/#handling-dismissals
      } else if (result.dismiss === Swal.DismissReason.cancel) {
        Swal.fire(
          'Cancelled',
          'Your employee is safe :)',
          'error'
        )
      }
    });
  }

  public onDeleteAllEmployees(): void {
    Swal.fire({
      title: 'Are you sure?',
      text: 'You will delete all employees ',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, keep it'
    }).then((result) => {
      if (result.isConfirmed) {
        this._employeeService.deleteAllEmployees().subscribe(
          (response: Employee) => {
            console.log(`Employee deleted`);
            // this.employee = response;
            this.getEmployees();
          },
          (error: HttpErrorResponse) => {
            console.error(error);
          }
        );
        Swal.fire(
          'Deleted!',
          'Your employees has been deleted.',
          'success'
        )
      // For more information about handling dismissals please visit
      // https://sweetalert2.github.io/#handling-dismissals
      } else if (result.dismiss === Swal.DismissReason.cancel) {
        Swal.fire(
          'Cancelled',
          'Your employees is safe :)',
          'error'
        )
      }
    });
  }

  onChange(event:any){
    console.log(event);
    
    this.size=event;
  }

}
