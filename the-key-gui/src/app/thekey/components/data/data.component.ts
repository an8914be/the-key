import {Component, OnInit} from '@angular/core';
import {WebsocketService} from "../../services/websocket/websocket.service";
import {isEqual} from "lodash";
import {Message} from "stompjs";
import * as SockJS from "sockjs-client";
import {environment} from "../../../../environments/environment";
import * as Stomp from "stompjs";

/**
 * DataComponent that fetch and render the word-count-map from the key academy blog
 */
@Component({
  selector: 'app-data',
  templateUrl: './data.component.html',
  styleUrls: ['./data.component.css']
})
export class DataComponent implements OnInit {
  private _websocketService: WebsocketService | undefined;

  blogPostData: Message | undefined;

  constructor() {
    this._websocketService = new WebsocketService(
      Stomp.over(new SockJS(environment.wsServer)),
      (message: Message) => {
        this.handleReceivedMessages(message);
      });
  }

  ngOnInit(): void {
  }

  handleReceivedMessages(message: Message): void {
    const incomingMessage = JSON.parse(message.body);
    if (!isEqual(incomingMessage, this.blogPostData)) {
      this.blogPostData = incomingMessage;
      this.ngOnInit();
    }
  }
}
