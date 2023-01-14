import React from "react";
import { BsPlus } from "react-icons/bs";
import SideBarIcon from "./widgets/SideBarIcon";
import Divider from "./widgets/Divider";
import SmallLogo from "../../../widgets/SmallLogo";
import { useDispatch, useSelector } from "react-redux";
import { updateIsAddGroupPressed, updateIsHomePressed } from "../../../redux/home";

const SideBar = () => {
  const dispatch= useDispatch();
  const isHomePressed = useSelector((state) => state.home.isHomePressed);
  const isAddGroupPressed = useSelector(
    (state) => state.home.isAddGroupPressed
  );

  return (
    <div className="fixed top-0 left-0 h-screen w-16 flex flex-col bg-white dark:bg-gray-900 shadow-lg">
      <button type="button" onClick={() => dispatch(updateIsHomePressed(!isHomePressed))}>
        <SideBarIcon icon={<SmallLogo size="28" />} />
      </button>
      <Divider />
      <button type="button" onClick={() => dispatch(updateIsAddGroupPressed(!isAddGroupPressed))}>
        <SideBarIcon icon={<BsPlus size="32" />} />
      </button>
    </div>
  );
};

export default SideBar;
