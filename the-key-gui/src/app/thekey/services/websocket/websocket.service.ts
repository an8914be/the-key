import * as Stomp from 'stompjs';
import {environment} from "../../../../environments/environment";
import {Message} from "stompjs";

/**
 * Class for WebsocketService
 */
export class WebsocketService {
  /**
   * Member for _stompClient
   */
  private readonly _stompClient: Stomp.Client;

  /**
   * Member-function for _receivedMessageCallback
   */
  private readonly _receivedMessageCallback: (message: Message) => void;

  /**
   * The constructor
   * When the constructor was called, then the he try to connect to
   * the websocket connection
   * @param stompClient
   * @param receivedMessageCallback
   */
  constructor(stompClient: Stomp.Client, receivedMessageCallback: (message: Message) => void) {
    this._stompClient = stompClient;
    this._receivedMessageCallback = receivedMessageCallback;
    this.connect();
  }

  /**
   * Connect the client to the websocket connection
   */
  connect() {
    this._stompClient.connect({}, () => {
      this._stompClient.subscribe(environment.wsConnectionUrl, this._receivedMessageCallback)
    }, error => {
      this.errorCallBack(error.toString());
    });
  };

  /**
   * Disconnect the client from the websocket connection
   */
  disconnect() {
    if (this._stompClient !== null) {
      this._stompClient.disconnect(() => {
      });
    }
  }

  /**
   * Callback function for error handling
   * Try to reconnect
   *
   * @param error
   */
  errorCallBack(error: string) {
    setTimeout(() => {
      this.connect();
    }, 5000);
  }

  /**
   * Send websocket message to defined endpoint
   * @param message
   */
  send(message: string) {
    this._stompClient.send(environment.wsSendMessageUrl, {}, JSON.stringify(message));
  }
}
