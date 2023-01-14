import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import TopNavigation from "../topnavigation/TopNavigation";
import Msg from "./widgets/Msg";
import MsgInput from "./widgets/MsgInput";

const ContentContainer = () => {
  const dispatch = useDispatch();
  const [dirMsgs, setDirMsgs] = useState();
  const currMsgs = useSelector((state) => state.msgs.currentMsgs);

  useEffect(() => {
    setDirMsgs(currMsgs);
  }, [currMsgs]);

  return (
    <div className="flex flex-col bg-gray-300 dark:bg-gray-600 m-0 h-screen w-full overflow-hidden">
      <TopNavigation />
      <div className="flex flex-col items-center h-full w-full mt-0 ml-0 mx-auto px-0 pb-12 overflow-y-scroll">
        {dirMsgs?.map((msg) => {
          var date = String(msg.createdAt).substring(0, 10);
          var time = String(msg.createdAt).substring(11, 19);
          return (
            <Msg
              name={msg.fromUserNickname}
              pictureId={msg.fromUserPictureId}
              timestamp={date + " " + time}
              text={msg.msgText}
              key={msg.msgUuid}
            />
          );
        })}
      </div>
      <MsgInput />
    </div>
  );
};

export default ContentContainer;
