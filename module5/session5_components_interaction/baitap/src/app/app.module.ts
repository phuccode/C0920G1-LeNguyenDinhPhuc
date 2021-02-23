import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { CountdownTimerComponent } from './countdown-timer/countdown-timer.component';
import { RatingBarComponent } from './rating-bar/rating-bar.component';
import { PipeDemoComponent } from './pipe-demo/pipe-demo.component';
import { HackerComponent } from './hacker/hacker.component';
import {FormsModule} from '@angular/forms';
import { LikesComponent } from './likes/likes.component';

@NgModule({
  declarations: [
    AppComponent,
    CountdownTimerComponent,
    RatingBarComponent,
    PipeDemoComponent,
    HackerComponent,
    HackerComponent,
    LikesComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
