import React from "react";
import TopNavigation from "../topnavigation/TopNavigation";
import Msg from "./widgets/Msg";
import MsgInput from "./widgets/MsgInput";

const ContentContainer = () => {
  return (
    <div className="flex flex-col bg-gray-300 dark:bg-gray-700 m-0 h-screen w-full overflow-hidden">
      <TopNavigation />
      <div className="flex flex-col items-center h-full w-full mt-0 ml-0 mx-auto px-0 pb-12 overflow-y-scroll">
        <Msg name="Leon" timestamp="one week ago" text={`Zdr tigur`}/>
      </div>
      <MsgInput />
    </div>
  );
};

export default ContentContainer;
