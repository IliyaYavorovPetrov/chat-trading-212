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
      if (data[0].friendshipUuid) {
        console.log("friendship rec");
        dispatch(assignFriends(data));
      } else if (data[0].chatUuid) {
        console.log(data);
        dispatch(assignCurrentMsgs(data));
      }
    } catch (error) {
      console.log(error);
    }
  };
};

export default useWebSocket;
