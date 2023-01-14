import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import PlusIconImage from "./PlusIconImage";
import { IoMdSend } from "react-icons/io";
import { BsEmojiSmileFill } from "react-icons/bs";
import EmojiPicker from "emoji-picker-react";

const MsgInput = () => {
  const dispatch = useDispatch();
  const jwtToken = useSelector((state) => state.jwt.token);
  const userUuid = useSelector((state) => state.user.userUuid);
  const nickname = useSelector((state) => state.user.nickname);
  const pictureId = useSelector((state) => state.user.pictureId);
  const currMsgs = useSelector((state) => state.msgs.currentMsgs);
  const [inputMsg, setInputMsg] = useState("");
  const [emoji, setEmoji] = useState(false);

  async function sendMsg() {
    const msgBody = {
      chatUuid: currMsgs[0].chatUuid,
      msgText: inputMsg,
      fromUserUuid: userUuid,
      fromUserNickname: nickname,
      fromUserPictureId: pictureId,
    };

    const response = await fetch("/home/chats", {
      headers: {
        Authorization: "Bearer " + jwtToken,
        "Content-Type": "application/json",
      },
      method: "post",
      body: JSON.stringify(msgBody),
    });

    setInputMsg("");
  }

  return (
    <div className="flex flex-row items-center justify-between fixed left-88 right-8 bottom-0 rounded-lg shadow-lg bg-gray-400 dark:bg-gray-700 px-2 h-12">
      <PlusIconImage />
      <button type="button" onClick={() => {setEmoji(true)}}>
        <BsEmojiSmileFill
          size="24"
          className="text-blue-500 dark:shadow-lg mx-2 dark:text-primary hover:scale-110 cursor-pointer"
        />
      </button>
      {emoji && (
        <EmojiPicker
          searchDisabled="true"
          previewConfig={{ showPreview: false }}
          emojiStyle="google"
          onEmojiClick={(e) => {
            setInputMsg((input) => input + e.emoji);
            setEmoji(false);
          }}
          height={400}
          width="40%"
        />
      )}
      <input
        className="w-full font-sans font-semibold bg-transparent outline-none text-gray-600 dark:text-gray-400 placeholder-gray-500 pl-1 rounded"
        type="text"
        placeholder="Enter message..."
        value={inputMsg}
        onChange={(event) => setInputMsg(event.target.value)}
      />
      <button type="button" onClick={() => sendMsg()}>
        <IoMdSend
          size="18"
          className="text-secondary my-auto text-blue-500 dark:shadow-lg mx-2 dark:text-primary hover:scale-110 cursor-pointer"
        />
      </button>
    </div>
  );
};

export default MsgInput;
