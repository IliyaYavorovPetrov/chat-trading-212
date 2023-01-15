import React, { useState } from "react";
import { BsPlusCircleFill } from "react-icons/bs";
import { useSelector } from "react-redux";

const PlusIconImage = () => {
  const jwtToken = useSelector((state) => state.jwt.token);
  const userUuid = useSelector((state) => state.user.userUuid);
  const nickname = useSelector((state) => state.user.nickname);
  const pictureId = useSelector((state) => state.user.pictureId);
  const currMsgs = useSelector((state) => state.msgs.currentMsgs);
  const [selectedFile, setSelectedFile] = useState();
  const [isFilePicked, setIsFilePicked] = useState(false);

  const upload = (event) => {
    console.log(event.target.files[0].name);
    const data = new FormData();
    data.append("file", event.target.files[0]);
    data.append("upload_preset", "zps5pozv");
    data.append("cloud_name", "duiqnhfar");

    fetch(" https://api.cloudinary.com/v1_1/duiqnhfar/image/upload", {
      method: "post",
      body: data,
    })
      .then((resp) => resp.json())
      .then((data) => {
        sendUrlMsg(data.url);
      })
      .catch((err) => console.log(err));
  };

  async function sendUrlMsg(url) {
    // const msgBody = {
    //   chatUuid: currMsgs[0].chatUuid,
    //   msgText: url,
    //   fromUserUuid: userUuid,
    //   fromUserNickname: nickname,
    //   fromUserPictureId: pictureId,
    // };

    // const response = await fetch("/home/chats", {
    //   headers: {
    //     Authorization: "Bearer " + jwtToken,
    //     "Content-Type": "application/json",
    //   },
    //   method: "post",
    //   body: JSON.stringify(msgBody),
    // });
  };

  return (
    <label
      htmlFor="file-upload"
      type="file"
      style={{
        backgroundImage: { BsPlusCircleFill },
      }}
    >
      <BsPlusCircleFill
        size="22"
        className="text-blue-500 dark:shadow-lg mx-2 dark:text-primary hover:scale-110 cursor-pointer"
      />
      <input
        type="file"
        id="file-upload"
        onChange={(event) => upload(event)}
        style={{ display: "none" }}
      />
    </label>
  );
};

export default PlusIconImage;
