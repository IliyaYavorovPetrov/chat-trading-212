import React from "react";

import { BsPlus, BsFillLightningFill, BsGearFill } from "react-icons/bs";
import { FaPoo } from "react-icons/fa";
import SmallLogo from "../../../widgets/SmallLogo";

const SideBar = () => {
  return (
    <div className="fixed top-0 left-0 h-screen w-16 flex flex-col bg-white dark:bg-gray-900 shadow-lg">
      <SideBarIcon icon={<SmallLogo size="28" />} />
      <Divider />
      <SideBarIcon icon={<BsPlus size="32" />} />
      <SideBarIcon icon={<BsFillLightningFill size="20" />} />
      <SideBarIcon icon={<FaPoo size="20" />} />
      <Divider />
      <SideBarIcon icon={<BsGearFill size="22" />} />
    </div>
  );
};

const SideBarIcon = ({ icon, text = "tooltip 💡" }) => (
  <div className="relative flex items-center justify-center h-12 w-12 mt-2 mb-2 mx-auto bg-gray-400 hover:bg-blue-600 dark:bg-gray-800 text-blue-500 hover:text-white hover:rounded-xl rounded-3xl transition-all duration-300 ease-linear cursor-pointer shadow-lg group">
    {icon}
    <span class="absolute w-auto p-2 m-2 min-w-max left-14 rounded-md shadow-md text-white bg-gray-900 text-xs font-bold transition-all duration-100 scale-0 origin-left group-hover:scale-100">
      {text}
    </span>
  </div>
);

const Divider = () => (
  <hr className=" bg-gray-200 dark:bg-gray-800 border border-gray-200 dark:border-gray-800 rounded-full mx-2" />
);

export default SideBar;
