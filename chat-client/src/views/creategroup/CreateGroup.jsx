import { click } from "@testing-library/user-event/dist/click";
import React, { useEffect, useState } from "react";
import { updateIsAddGroupPressed } from "../../redux/home";
import { BsPlus } from "react-icons/bs";
import { useDispatch, useSelector } from "react-redux";
import { useNavigate } from "react-router-dom";
import { returnJwtToDefault } from "../../redux/jwt";
import { updateTextGroupNameInput, updateUrlGroupName } from "../../redux/home";
import CloseButton from "../../widgets/CloseButton";
import Friend from "../home/addfriend/widgets//Friend";
import NoUserFound from "../home/addfriend/widgets//NoUserFound";
import NameGroupInput from "./widgets/NameGroupInput";
import AddImageGroupButton from "./widgets/AddImageGroupButton";
import CreateGroupButton from "./widgets/CreateGroupButton";

const CreateGroup = () => {
  const dispatch = useDispatch();
  const jwtToken = useSelector((state) => state.jwt.token);
  const userUuid = useSelector((state) => state.user.userUuid);
  const textGroup = useSelector((state) => state.home.textGroupNameInput);
  const textUrl = useSelector((state) => state.home.urlGroupName);
  const [groupName, setGroupName] = useState();
  const [url, setUrl] = useState();

  useEffect(() => {
    setGroupName(textGroup);
  }, [textGroup]);
  useEffect(() => {
    setUrl(textUrl);
  }, [textUrl]);

  async function sendFriendRequest(
    friendUserUuid,
    friendNickname,
    friendPictureId
  ) {}

  function giveAddFriendOptions() {
    return (
      <div className="flex flex-col">
        <div className="flex flex-row"></div>
      </div>
    );
  }

  return (
    <div className="absolute top-1/3 left-1/3 flex-col grid grid-cols-1 sm:grid-cols-2 h-96 dark:bg-gray-700 bg-gray-400 rounded-lg">
      <div className="relative flex items-center justify-center">
        <img
          src={textUrl}
          alt=""
          className="absolute w-4/5 h-4/5 rounded-full shadow-md object-cover dark:bg-gray-400 bg-gray-500 mb-auto mt-0 mx-0"
        />
      </div>
      <CloseButton
        icon={<BsPlus size="28" />}
        onClick={() => {
          dispatch(updateIsAddGroupPressed(false));
          dispatch(updateTextGroupNameInput(""));
          dispatch(updateUrlGroupName(""));
        }}
      ></CloseButton>
      <div className="flex flex-row">
        <div className="w-full mt-20 mb-2 p-2">
          <div className="flex flex-col justify-center dark:text-gray-400 text-gray-600 py-2 text-lg font-medium ">
            <div className="flex flex-col h-full">
              <div className="mt-0"></div>
              <div className="mt-16 flex flex-row justify-center items-center">
                <AddImageGroupButton />
                <NameGroupInput />
              </div>
              <div className="flex justify-center items-center">
                <CreateGroupButton text="Create Group" groupName={groupName} />
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default CreateGroup;
