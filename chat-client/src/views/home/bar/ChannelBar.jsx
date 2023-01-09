import React from "react";

const ChannelBar = () => {
  return (
    <div className="w-80 h-screen m-0 ml-16 bg-gray-200 dark:bg-gray-800 overflow-hidden shadow-lg">
      <div className="flex items-center justify-center h-16 m-0 p-0">
        <h5 className="text-lg tracking-wider font-bold text-gray-600 dark:text-gray-400 mr-auto ml-4 my-auto align-middle">
          Friends
        </h5>
      </div>
      <div className="flex flex-col items-center justify-start p-1 m-0"></div>
    </div>
  );
};

export default ChannelBar;
