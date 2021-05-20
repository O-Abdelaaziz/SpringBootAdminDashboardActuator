import { SystemCpu } from './../schema/system-cpu';
import { SystemHealth } from './../schema/system-health';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AdminDashboardService {
  private SERVER_URL:String="http://localhost:8080/admin-actuator";

  constructor(private http: HttpClient) { }

  
  public getHttpTraces(): Observable<any> {
    return this.http.get<any>(`${this.SERVER_URL}/httptrace`);
  }

  public getSystemHealth(): Observable<SystemHealth> {
    return this.http.get<SystemHealth>(`${this.SERVER_URL}/health`);
  }

  public getSystemCpu(): Observable<SystemCpu> {
    return this.http.get<SystemCpu>(`${this.SERVER_URL}/metrics/system.cpu.count`);
  }

  public getProcessUptime(): Observable<any> {
    return this.http.get<any>(`${this.SERVER_URL}/metrics/process.uptime`);
  }

}
