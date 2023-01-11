import * as SockJS from 'sockjs-client';
import SockJsClient from 'react-stomp';

var stompClient = null;

function connect() {
    var socket = new SockJS('/gs-guide-websocket');
    // stompClient = Stomp.over(socket);
    // stompClient.connect({}, function (frame) {
    //     setConnected(true);
    //     console.log('Connected: ' + frame);
    //     stompClient.subscribe('/topic/greetings', function (greeting) {
    //         showGreeting(JSON.parse(greeting.body).content);
    //     });
    // });
}