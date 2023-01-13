import { useEffect } from "react";
import { over } from "stompjs";
import SockJS from "sockjs-client";
import { useDispatch, useSelector } from "react-redux";
import { assignFriends, updateFriends } from "../redux/friends";
import { assignCurrentMsgs } from "../redux/msgs";

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
    try {
      var data = JSON.parse(payload.body);
      if (data[0].friendshipUuid) {
        dispatch(updateFriends(data));
      } else if (data[0].msgUuid) {
        dispatch(assignCurrentMsgs(data));
      } else {
        console.log("bad");
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

  return { sendMsg, closeSocket };
};

export default useWebSocket;
