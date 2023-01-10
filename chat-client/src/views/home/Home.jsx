import React from "react";
import { useSelector } from "react-redux";
import AddFriend from "./addfriend/AddFriend";
import ChannelBar from "./bar/ChannelBar";
import ContentContainer from "./content/ContentContainer";
import SideBar from "./sidebar/SideBar";
import UserInfo from "./userinfo/UserInfo";

function Home() {
  const showUserInfo = useSelector((state) => state.home.showUserInfo);
  const showAddFriends = useSelector((state) => state.home.showAddFriends);
  return (
    <div className="flex">
      <SideBar />
      <ChannelBar />
      <ContentContainer />
      {showUserInfo && <UserInfo />}
      {showAddFriends && <AddFriend />}
    </div>
  );
}

export default Home;
