import React from "react";
import { FaSearch, FaUserCircle } from "react-icons/fa";

import ThemeIcon from "../../../widgets/ThemeIcon";
import UserCircle from "./widgets/UserCircle";

const TopNavigation = () => {
  return (
    <div className="flex flex-row items-center justify-end bg-gray-300 dark:bg-gray-700 bg-opacity-90 w-full h-16 m-0 shadow-lg">
      <ThemeIcon />
      <UserCircle />
    </div>
  );
};

export default TopNavigation;
