import React, { useEffect, useState } from "react";
import { BsPlus } from "react-icons/bs";
import SideBarIcon from "./widgets/SideBarIcon";
import Divider from "./widgets/Divider";
import SmallLogo from "../../../widgets/SmallLogo";
import { useDispatch, useSelector } from "react-redux";
import {
  updateIsAddGroupPressed,
  updateIsHomePressed,
} from "../../../redux/home";

const SideBar = () => {
  const dispatch = useDispatch();
  const isHomePressed = useSelector((state) => state.home.isHomePressed);
  const isAddGroupPressed = useSelector(
    (state) => state.home.isAddGroupPressed
  );

  const groupsRedux = useSelector((state) => state.group.groups);
  const [groups, setGroups] = useState();

  useEffect(() => {
    setGroups(groupsRedux);
  }, [groupsRedux]);

  return (
    <div className="fixed top-0 left-0 h-screen w-16 flex flex-col bg-white dark:bg-gray-900 shadow-lg">
      <button
        type="button"
        onClick={() => dispatch(updateIsHomePressed(!isHomePressed))}
      >
        <SideBarIcon icon={<SmallLogo size="28" />} />
      </button>
      {groups?.map((group) => {
        return (
          <button type="button" onClick={() => console.log("Clicky")}>
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
