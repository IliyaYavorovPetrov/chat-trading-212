import React, { useEffect, useState } from "react";
import { useSelector } from "react-redux";
import WebSockets from "../../websockets/WebSockets";
import AddFriend from "./addfriend/AddFriend";
import Bar from "./bar/Bar";
import ContentContainer from "./content/ContentContainer";
import SideBar from "./sidebar/SideBar";
import UserInfo from "./userinfo/UserInfo";
import useWebSocket from "../../websockets/WebSockets";

function Home() {
  const showUserInfo = useSelector((state) => state.home.showUserInfo);
  const showAddFriends = useSelector((state) => state.home.showAddFriends);
  const { sendMsg, closeSocket } = useWebSocket();
  return (
    <div className="flex">
      <SideBar />
      <Bar />
      <ContentContainer />
      {showUserInfo && <UserInfo />}
      {showAddFriends && <AddFriend />}
    </div>
  );
}

export default Home;
