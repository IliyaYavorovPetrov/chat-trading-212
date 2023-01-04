import React from "react";
import ChannelBar from "./widgets/ChannelBar";
import ContentContainer from "./widgets/ContentContainer";
import SideBar from "./widgets/SideBar";

function Home() {
    return (
      <div className='flex'>
          <SideBar />
          <ChannelBar />
          <ContentContainer />
      </div>
    )
}
  
export default Home;