import { useEffect } from "react";
import { over } from "stompjs";
import SockJS from "sockjs-client";
import { useDispatch, useSelector } from "react-redux";
import { assignFriends } from "../redux/friends";

let socket = null;
let stompClient = null;

const useWebSocket = () => {
  const userUuid = useSelector((state) => state.user.userUuid);
  const dispatch = useDispatch();

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
    if (payload.friendshipUuid) {
        console.log(payloadData);
        dispatch(assignFriends(payloadData));
    }
    else {
        console.log("No such object");
    }
  };

  const sendMsg = (url, message) => {
    stompClient.send("http://localhost:8080" + url, {}, JSON.stringify(message));
  };

  const closeSocket = () => {
    console.log("close socket");
  };

  return { sendMsg, closeSocket };
};

export default useWebSocket;
