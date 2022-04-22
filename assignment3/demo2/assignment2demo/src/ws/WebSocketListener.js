import {EventEmitter} from "events"
import {Client} from "@stomp/stompjs"

class WebSocketListener extends EventEmitter{
    constructor(username, password) {
        super();
        this.client = new Client({
            brokerURL: "ws://localhost:8080/api/websocket",
            connectHeaders: {
              login: username,
              passcode: password
            },
            onConnect: () => {
                this.client.subscribe("/topic/events", message => {
                    const receivedMessage = JSON.parse(message.body);
                    this.emit(receivedMessage.type, receivedMessage)
                })
            }
        });
        this.client.activate();
    }
}

const WebSocketListenerInstance = new WebSocketListener("teacher1", "password1");

export default WebSocketListenerInstance;