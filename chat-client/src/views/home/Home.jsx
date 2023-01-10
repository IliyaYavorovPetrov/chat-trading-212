import React from "react";
import { useSelector } from "react-redux";
import ChannelBar from "./bar/ChannelBar";
import ContentContainer from "./content/ContentContainer";
import SideBar from "./sidebar/SideBar";
import UserInfo from "./userinfo/UserInfo";

function Home() {
  const showUserInfo = useSelector((state) => state.home.showUserInfo);
  return (
    <div className="flex">
      <SideBar />
      <ChannelBar />
      <ContentContainer />
      {showUserInfo && <UserInfo />}
    </div>
  );
}

export default Home;
