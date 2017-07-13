import {Component} from '@angular/core';
import {Http} from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  private http: Http;
private url : string;
  constructor(http: Http) {
    this.http = http;
this.url  = 'http://localhost:8080/quote?symbol=aapl';
  }


  public randomize() {
    this.getObservable().subscribe(){
      data => this.title = JSON.stringify(data),
        error => console.log(error),
        () => console.log("finished")

    };
  }
  public getObservable(){
    console.log("about to send");
    this.title = "about to call";
    return this.http.get(this.url).map(res => res.json());
  }

  private extractData(res: Response) {

  }

  title = 'app works!';
}
