import React from "react";

const SideBarIcon = ({ icon }) => (
  <div className="relative flex items-center justify-center h-12 w-12 mt-2 mb-2 mx-auto bg-gray-400 hover:bg-blue-600 dark:bg-gray-800 text-blue-500 hover:text-white hover:rounded-xl rounded-3xl transition-all duration-300 ease-linear cursor-pointer shadow-lg group">
    {icon}
  </div>
);

export default SideBarIcon;
