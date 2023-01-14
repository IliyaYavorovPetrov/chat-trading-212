import React, { useEffect, useState } from "react";
import { useSelector } from "react-redux";
import WebSockets from "../../websockets/WebSockets";
import CreateGroup from "../creategroup/CreateGroup";
import AddFriend from "./addfriend/AddFriend";
import Bar from "./bar/Bar";
import ContentContainer from "./content/ContentContainer";
import SideBar from "./sidebar/SideBar";
import UserInfo from "./userinfo/UserInfo";

function Home() {
  const showUserInfo = useSelector((state) => state.home.showUserInfo);
  const showAddFriends = useSelector((state) => state.home.showAddFriends);
  const isAddGroupPressed = useSelector((state) => state.home.isAddGroupPressed);
  return (
    <div className="flex">
      <SideBar />
      <Bar />
      <ContentContainer />
      {showUserInfo && <UserInfo />}
      {showAddFriends && <AddFriend />}
      {isAddGroupPressed && <CreateGroup />}
    </div>
  );
}

export default Home;
