import React from "react";
import ChannelBar from "./widgets/ChannelBar";
import ContentContainer from "./widgets/ContentContainer";
import SideBar from "./widgets/SideBar";
import useLocalStorage from "../../hooks/LocalStorage";

function Home() {
  const [jwt, setJwt] = useLocalStorage("default_token", "jwt");
    return (
      <div className='flex'>
          <SideBar />
          <ChannelBar />
          <ContentContainer />
      </div>
    )
}
  
export default Home;