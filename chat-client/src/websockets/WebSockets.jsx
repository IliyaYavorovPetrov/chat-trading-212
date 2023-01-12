import { useEffect } from "react";
import { over } from "stompjs";
import SockJS from "sockjs-client";
import { icons } from "react-icons";

let socket = null;
let stompClient = null;

const useWebSocket = () => {
  useEffect(() => {
    socket = new SockJS("http://localhost:8080/ws");
    stompClient = over(socket);
    stompClient.connect(
      {},
      () => {
        console.log("connected");
        stompClient.subs
      },
      () => {
        console.log("error");
      }
    );
  }, []);

  const sendMsg = (message) => {
    console.log("send msg");
  };

  const closeSocket = () => {
    socket.close("close socket");
  };

  return { sendMsg, closeSocket };
};

export default useWebSocket;
