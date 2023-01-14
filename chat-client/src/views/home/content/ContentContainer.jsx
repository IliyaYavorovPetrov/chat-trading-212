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
  var regexImg =
    /http:\/\/res\.cloudinary\.com\/duiqnhfar\/image\/upload\/v\d+\/\w+\./;
  return (
    <div className="flex flex-col bg-gray-300 dark:bg-gray-600 m-0 h-screen w-full overflow-hidden">
      <TopNavigation />
      <div className="flex flex-col items-center h-full w-full mt-0 ml-0 mx-auto px-0 pb-12 overflow-y-scroll">
        {dirMsgs?.map((msg) => {
          {
            /* var date = String(msg.createdAt).substringisHomePressed(0, 10);
          var time = String(msg.createdAt).substring(11, 19); */
          }
          if (regexImg.test(msg.msgText)) {
            return (
              <div className="w-full flex flex-row items-center justify-start py-4 px-8 m-0 cursor-pointer">
                <div className="flex flex-col items-center w-12">
                  <img
                    src={`https://robohash.org/${msg.fromUserPictureId}?set=set2&size=180x180`}
                    alt=""
                    className="flex-none w-14 h-full rounded-full shadow-md object-cover dark:bg-gray-400 bg-gray-500 mb-auto mt-0 mx-0 cursor-pointer"
                  />
                </div>
                <div className="w-4/5 flex flex-col justify-start ml-4">
                  <p className="text-left font-bold text-gray-800 dark:text-gray-300 mr-2 cursor-pointer">
                    {msg.fromUserNickname}
                    <small className="text-xs text-left font-semibold text-gray-500 dark:text-gray-400 ml-2">
                      {msg.createdAt}
                    </small>
                  </p>
                  <p className="text-lg text-left text-gray-800 dark:text-white mr-auto whitespace-normal">
                    <img src={msg.msgText} alt="" className="w-64 h-64" />
                  </p>
                </div>
              </div>
            );
          }
          return (
            <Msg
              name={msg.fromUserNickname}
              pictureId={msg.fromUserPictureId}
              timestamp={msg.createdAt}
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
