import React, { useEffect, useState } from "react";
import { useSelector } from "react-redux";
import AddFriend from "./addfriend/AddFriend";
import Bar from "./bar/Bar";
import ContentContainer from "./content/ContentContainer";
import SideBar from "./sidebar/SideBar";
import UserInfo from "./userinfo/UserInfo";

function Home() {
  const showUserInfo = useSelector((state) => state.home.showUserInfo);
  const showAddFriends = useSelector((state) => state.home.showAddFriends);
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
