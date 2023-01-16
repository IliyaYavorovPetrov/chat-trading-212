import React, { useEffect, useState } from "react";
import { BsPlus } from "react-icons/bs";
import SideBarIcon from "./widgets/SideBarIcon";
import Divider from "./widgets/Divider";
import SmallLogo from "../../../widgets/SmallLogo";
import { useDispatch, useSelector } from "react-redux";
import { assignCurrentGroupId, assignGroups } from "../../../redux/groups";
import { assignCurrentMsgs, assignMsgs } from "../../../redux/msgs";
import { assignFriends } from "../../../redux/friends";

import {
  updateIsAddGroupPressed,
  updateIsStart,
  updateIsHomePressed,
} from "../../../redux/home";

const SideBar = () => {
  const dispatch = useDispatch();
  const jwtToken = useSelector((state) => state.jwt.token);
  const userUuid = useSelector((state) => state.user.userUuid);
  const isHomePressed = useSelector((state) => state.home.isHomePressed);
  const groupUuid = useSelector((state) => state.group.currGroupUuid);

  const isAddGroupPressed = useSelector(
    (state) => state.home.isAddGroupPressed
  );

  const groupsRedux = useSelector((state) => state.group.groups);
  const [groups, setGroups] = useState();

  useEffect(() => {
    setGroups(groupsRedux);
  }, [groupsRedux]);

  async function getGroupsUser() {
    const response = await fetch("/home/groups/" + userUuid, {
      headers: {
        Authorization: "Bearer " + jwtToken,
        "Content-Type": "application/json",
      },
      method: "get",
    });

    if (!response.ok) {
      return;
    }

    const data = await response.json();
    dispatch(assignGroups(data));
  }

  async function getFriendshipUser() {
    const response = await fetch("/home/friends/get/" + userUuid, {
      headers: {
        Authorization: "Bearer " + jwtToken,
        "Content-Type": "application/json",
      },
      method: "get",
    });

    if (!response.ok) {
      return;
    }

    const data = await response.json();
    dispatch(assignFriends(data));
  }

  async function getMemebersInGroup(groupid) {
    const response = await fetch("/home/groups/users/" + groupid, {
      headers: {
        Authorization: "Bearer " + jwtToken,
        "Content-Type": "application/json",
      },
      method: "get",
    });

    if (!response.ok) {
      return;
    }

    const data = await response.json();
    dispatch(assignFriends(data));
  }

  async function getGroupMsgs(chatUuid) {
    const response = await fetch("/home/chats/" + chatUuid, {
      headers: {
        Authorization: "Bearer " + jwtToken,
        "Content-Type": "application/json",
      },
      method: "get",
    });

    if (!response.ok) {
      return;
    }

    const data = await response.json();
    dispatch(assignCurrentMsgs(data));
  }

  useEffect(() => {
    getGroupsUser();
  }, []);

  return (
    <div className="fixed top-0 left-0 h-screen w-16 flex flex-col bg-white dark:bg-gray-900 shadow-lg">
      <button
        type="button"
        onClick={() => {
          console.log("Home Button");
          dispatch(updateIsHomePressed(true));
          getFriendshipUser();
        }}
      >
        <SideBarIcon icon={<SmallLogo size="28" />} />
      </button>
      {groups?.map((group) => {
        return (
          <button
            type="button"
            onClick={() => {
              ;
              dispatch(updateIsStart(false));
              dispatch(assignCurrentGroupId(group.groupUuid));
              dispatch(updateIsHomePressed(false));
              getGroupMsgs(group.groupUuid);
              getMemebersInGroup(group.groupUuid);
            }}
          >
            <img
              src={group.groupUrl}
              alt=""
              className="relative flex items-center justify-center h-12 w-12 mt-2 mb-2 mx-auto bg-gray-400 hover:bg-blue-600 dark:bg-gray-800 text-blue-500 hover:text-white hover:rounded-xl rounded-3xl transition-all duration-300 ease-linear cursor-pointer shadow-lg group"
            ></img>
          </button>
        );
      })}
      <Divider />
      <button
        type="button"
        onClick={() => dispatch(updateIsAddGroupPressed(!isAddGroupPressed))}
      >
        <SideBarIcon icon={<BsPlus size="32" />} />
      </button>
    </div>
  );
};

export default SideBar;
