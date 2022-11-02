import * as Stomp from 'stompjs';
import {WebsocketService} from './websocket.service';
import {Message} from "stompjs";
import {environment} from "../../../../environments/environment";

/**
 * Test class for WebsocketService
 */
describe('WebsocketService', () => {
  let clientSpy: jasmine.SpyObj<Stomp.Client>;
  let webSocketService: WebsocketService | undefined;

  const callbackFunction = (_: Message) => {
    console.log("I'm a callback-function.")
  }

  beforeEach(() => {
    clientSpy = jasmine.createSpyObj('Client', ['connect', 'subscribe', 'disconnect', 'send']);

    clientSpy.send.and.callThrough();
    clientSpy.connect.and.callThrough();
    clientSpy.disconnect.and.callThrough();
    clientSpy.subscribe.and.callThrough();

    webSocketService = new WebsocketService(clientSpy, callbackFunction);
  });

  it('should be created', () => {
    expect(webSocketService).toBeTruthy();
    expect(clientSpy.connect).toHaveBeenCalled();
  });

  it('should connect to websocket', () => {
    webSocketService?.connect();
    expect(clientSpy.connect).toHaveBeenCalled();
  });

  it('should connect to websocket', () => {
    webSocketService?.disconnect();
    expect(clientSpy.disconnect).toHaveBeenCalled();
  });

  it('should send string to websocket', () => {
    const message = "Hello world";
    webSocketService?.send(message);
    expect(clientSpy.send).toHaveBeenCalledWith(environment.wsSendMessageUrl, {}, JSON.stringify(message));
  });
});
