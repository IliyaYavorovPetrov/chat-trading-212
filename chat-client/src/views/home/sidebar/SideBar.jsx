import React from "react";
import { BsPlus } from "react-icons/bs";
import SideBarIcon from "./widgets/SideBarIcon";
import Divider from "./widgets/Divider";
import SmallLogo from "../../../widgets/SmallLogo";

const SideBar = () => {
  return (
    <div className="fixed top-0 left-0 h-screen w-16 flex flex-col bg-white dark:bg-gray-900 shadow-lg">
      <SideBarIcon icon={<SmallLogo size="28" />} />
      <Divider />
      <SideBarIcon icon={<BsPlus size="32" />} />
    </div>
  );
};

export default SideBar;
