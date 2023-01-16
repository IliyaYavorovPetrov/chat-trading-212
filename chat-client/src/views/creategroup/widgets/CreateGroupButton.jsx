import React from "react";
import { useSelector } from "react-redux";

const CreateGroupButton = ({ text, groupName, url }) => {
  const jwtToken = useSelector((state) => state.jwt.token);
  const userUuid = useSelector((state) => state.user.userUuid);
  const userNickname = useSelector((state) => state.user.nickname);
  const userPictureId = useSelector((state) => state.user.userPictureId);

  const textGroupNameInput = useSelector(
    (state) => state.home.textGroupNameInput
  );
  const urlGroupName = useSelector((state) => state.home.urlGroupName);

  async function createGroup(groupName, url) {
    if (groupName === "") {
      return;
    }
    if (url === "") {
      return;
    }

    debugger;

    const groupReqBody = {
      groupName: textGroupNameInput,
      groupUrl: urlGroupName,
      userUuid: userUuid,
      userNickname: userNickname,
      userPictureId: userPictureId,
    };

    const response = await fetch("/home/groups/create", {
      headers: {
        Authorization: "Bearer " + jwtToken,
        "Content-Type": "application/json",
      },
      method: "post",
      body: JSON.stringify(groupReqBody),
    });
  }

  return (
    <button
      type="button"
      className="w-3/5 my-5 py-2 bg-blue-500 shadow-lg shadow-blue-500/50 hover:shadow-blue-500/40 text-white font-semibold rounded-lg"
      onClick={() => createGroup()}
    >
      {text}
    </button>
  );
};

export default CreateGroupButton;
