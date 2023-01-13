import React, { useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import PlusIconImage from "./PlusIconImage";
import { FaSearch } from "react-icons/fa";


const MsgInput = () => {
  const dispatch = useDispatch();
  const jwtToken = useSelector((state) => state.jwt.token);
  const userUuid = useSelector((state) => state.user.userUuid);
  const nickname = useSelector((state) => state.user.nickname);
  const pictureId = useSelector((state) => state.user.pictureId);
  const currMsgs = useSelector((state) => state.msgs.currentMsgs);
  const [inputMsg, setInputMsg] = useState("");

  async function sendMsg() {
    console.log("aaa");
    const msgBody = {
      chatUuid: currMsgs[0].chatUuid,
      msgText: inputMsg,
      fromUserUuid: userUuid,
      fromUserNickname: nickname,
      fromUserPictureId: pictureId,
    };

    const response = await fetch("/home/chats", {
      headers: {
        'Authorization': 'Bearer ' + jwtToken,
        "Content-Type": "application/json",
      },
      method: "post",
      body: JSON.stringify(msgBody),
    });
  }

  return (
    <div className="flex flex-row items-center justify-between fixed left-88 right-8 bottom-0 rounded-lg shadow-lg bg-gray-400 dark:bg-gray-700 px-2 h-12">
      <PlusIconImage />
      <input
        className="w-full font-sans font-semibold bg-transparent outline-none text-gray-600 dark:text-gray-400 placeholder-gray-500 pl-1 rounded"
        type="text"
        placeholder="Enter message..."
        value={inputMsg}
        onChange={(event) => setInputMsg(event.target.value)}
      />
      <button type="button" onClick={() => sendMsg()}>
        <FaSearch size="18" className="text-secondary my-auto dark:text-gray-500 text-gray-600" />
      </button>
    </div>
  );
};

export default MsgInput;
