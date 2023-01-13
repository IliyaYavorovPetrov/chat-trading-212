import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { assignFriends } from "../../../redux/friends";
import { assignCurrentMsgs, assignMsgs } from "../../../redux/msgs";
import FriendBar from "./widgets/FriendBar";
import TitleBar from "./widgets/TitleBar";
import useWebSocket from "../../../websockets/WebSockets"
import { over } from "stompjs";
import SockJS from "sockjs-client";


const Bar = () => {
  const dispatch = useDispatch();
  const jwtToken = useSelector((state) => state.jwt.token);
  const userUuid = useSelector((state) => state.user.userUuid);
  const friends = useSelector((state) => state.friends.friends);
  const {subscribeMe, closeSocket} = useWebSocket();

  let socket = null;
  let stompClient = null;

  socket = new SockJS("http://localhost:8080/ws");
  stompClient = over(socket);

  async function getFriendshipsUser() {
    const response = await fetch("/home/friends/get/" + userUuid, {
      headers: {
        Authorization: "Bearer " + jwtToken,
        "Content-Type": "application/json",
      },
      method: "get",
    });

    if (!response.ok) {
      return;
    }

    const data = await response.json();
    console.log(data);
    dispatch(assignFriends(data));
    console.log("subscribed to " + data[0].friendshipUuid);
    // subscribeMe("/user/" + data[0].friendshipUuid + "/private");
    stompClient.connect(
      {},
      () => {
        stompClient.subscribe("/user/" + data[0].friendshipUuid + "/private", onMsgReceived);
      },
      () => {
        console.log("error with web sockets");
      }
    );
  }

  const onMsgReceived = (payload) => {
    try {
      var data = JSON.parse(payload.body);
      if (data[0].hasOwnProperty("chatUuid")) {
        console.log("rec msg");
        console.log(data);
        dispatch(assignMsgs(data));
      } 
    } catch (error) {
      console.log(error);
    }
  };

  async function getFriendshipsMsgs(chatUuid) {
    const response = await fetch("/home/chats/" + chatUuid, {
      headers: {
        Authorization: "Bearer " + jwtToken,
        "Content-Type": "application/json",
      },
      method: "get",
    });

    if (!response.ok) {
      console.log("wtf");
      return;
    }

    const data = await response.json();
    console.log("msgs: " + data);
    dispatch(assignCurrentMsgs(data));
  }

  function giveAllFriends() {
    return (
      <div>
        {friends?.map((friend) => {
          return (
            <button
              className="w-full"
              type="button"
              onClick={() => {
                getFriendshipsMsgs(friend.friendshipUuid);
              }}
            >
              <FriendBar
                friendshipUuid={friend.friendshipUuid}
                userUuid={friend.userUuid}
                pictureId={friend.userPictureId}
                name={friend.userNickname}
                isActive={true}
                key={friend.friendshipUuid}
              />
            </button>
          );
        })}
      </div>
    );
  }

  useEffect(() => {
    getFriendshipsUser();
  }, []);

  return (
    <div className="flex flex-col w-96 justify-start h-screen">
      <TitleBar text="Friends" />
      <div className="flex flex-col bg-gray-200 dark:bg-gray-800 h-full w-full overflow-y-auto">
        {giveAllFriends()}
      </div>
    </div>
  );
};

export default Bar;
