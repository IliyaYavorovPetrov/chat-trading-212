import React from "react";
import { useDispatch, useSelector } from "react-redux";
import { updateAddFriend, updateShowUserInfo } from "../../../redux/home";

import ThemeIcon from "../../../widgets/ThemeIcon";
import UserCircle from "./widgets/UserCircle";
import UserFriend from "./widgets/UserFriends";

const TopNavigation = () => {
  const showUserInfo = useSelector((state) => state.home.showUserInfo);
  const showAddFriends = useSelector((state) => state.home.showAddFriends);
  const dispacth = useDispatch();

  return (
    <div className="flex flex-row items-center justify-end bg-gray-200 dark:bg-gray-700 bg-opacity-90 w-full h-16 m-0 shadow-lg">
      <ThemeIcon />
      <button
        type="button"
        onClick={() => {
          dispacth(updateAddFriend(!showAddFriends));
        }}
      >
        <UserFriend />
      </button>
      <button
        type="button"
        onClick={() => {
          dispacth(updateShowUserInfo(!showUserInfo));
        }}
      >
        <UserCircle />
      </button>
    </div>
  );
};

export default TopNavigation;
