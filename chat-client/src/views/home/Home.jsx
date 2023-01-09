import React from "react";
import ChannelBar from "./bar/ChannelBar";
import ContentContainer from "./content/ContentContainer";
import SideBar from "./sidebar/SideBar";

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