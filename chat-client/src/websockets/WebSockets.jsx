import { useEffect } from "react";
import { over } from "stompjs";
import SockJS from "sockjs-client";
import { useDispatch, useSelector } from "react-redux";
import { assignFriends, updateFriends } from "../redux/friends";
import { assignCurrentMsgs, assignMsgs } from "../redux/msgs";

let socket = null;
let stompClient = null;

const useWebSocket = () => {
  const dispatch = useDispatch();
  const userUuid = useSelector((state) => state.user.userUuid);
  const friends = useSelector((state) => state.friends.friends);

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
    try {
      var data = JSON.parse(payload.body);
      if (data[0].hasOwnProperty("friendshipUuid")) {
        console.log("hit it mada" + data);
        dispatch(assignFriends(data));
        stompClient.subscribe("/user/" + data[0].friendshipUuid + "/private");
      }
      if (data[0].hasOwnProperty("chatUuid")) {
        console.log("rec msg");
        console.log(data);
        dispatch(assignMsgs(data));
      } 
    } catch (error) {
      console.log(error);
    }
  };

  

  const sendMsg = (message) => {
    console.log("send msg");
  };

  const closeSocket = () => {
    console.log("close socket");
  };

  const subscribeMe = (url) => {
    stompClient.subscribe(url, ((payload) => {onMsgReceived(payload)}));
  };

  return { sendMsg, closeSocket, subscribeMe };
};

export default useWebSocket;
