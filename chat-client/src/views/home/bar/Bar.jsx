import React from "react";
import FriendBar from "./widgets/FriendBar";
import TitleBar from "./widgets/TitleBar";

const Bar = () => {
  return (
    <div className="flex flex-col w-96 justify-start h-screen">
      <TitleBar text="Friends" />
      <div className="flex flex-col bg-gray-200 dark:bg-gray-800 h-full w-full overflow-y-auto">
        <FriendBar pictureId={2} name="Yunakut" isActive={true} />
      </div>
    </div>
  );
};

export default Bar;
