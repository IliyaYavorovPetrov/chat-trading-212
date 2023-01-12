import { useEffect } from "react";
import { over } from "stompjs";
import SockJS from "sockjs-client";
import { useDispatch, useSelector } from "react-redux";
import { assignFriends } from "../redux/friends";

let socket = null;
let stompClient = null;

const useWebSocket = () => {
  const dispatch = useDispatch();
  const userUuid = useSelector((state) => state.user.userUuid);
  // const friends = useSelector((state) => state.friends.friends);

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
    // const data = JSON.parse(payload.data);
    // console.log(data);
    // dispatch(assignFriends(data));
    try {
      var data = JSON.parse(payload.body);
      dispatch(assignFriends(data));
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

  return { sendMsg, closeSocket };
};

export default useWebSocket;
