import React from "react";

const TitleBar = ({ text }) => {
  return (
    <div className="w-full m-0 ml-16 bg-gray-200 dark:bg-gray-800 overflow-hidden shadow-lg">
      <div className="flex items-center justify-center h-16 m-0 p-0">
        <h5 className="text-2xl tracking-wider font-bold text-gray-600 dark:text-gray-400 mr-auto ml-4 my-auto align-middle">
          {text}
        </h5>
      </div>
    </div>
  );
};

export default TitleBar;
