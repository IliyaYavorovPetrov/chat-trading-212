import { useEffect } from "react";
import { over } from "stompjs";
import SockJS from "sockjs-client";
import { useSelector } from "react-redux";

let socket = null;
let stompClient = null;

const useWebSocket = () => {
  const userUuid = useSelector((state) => state.user.userUuid);

  useEffect(() => {
    socket = new SockJS("http://localhost:8080/ws");
    stompClient = over(socket);
    stompClient.connect(
      {},
      () => {
        stompClient.subscribe("/user/" + userUuid + "/private", onMsgReceived);
      },
      () => {
        console.log("error with web sockets");
      }
    );
  }, []);

  const onMsgReceived = (payload) => {
    var payloadData = JSON.parse(payload.body);
    console.log(payloadData);
  };

  const sendMsg = (message) => {
    console.log("send msg");
  };

  const closeSocket = () => {
    console.log("close socket");
  };

  return { sendMsg, closeSocket };
};

export default useWebSocket;
