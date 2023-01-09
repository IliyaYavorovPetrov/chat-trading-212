import React from "react";
import PlusIconImage from "./PlusIconImage";

const MsgInput = () => (
  <div className="flex flex-row items-center justify-between fixed left-88 right-4 bottom-2 rounded-lg shadow-lg bg-gray-400 dark:bg-gray-600 px-2 h-12">
    <PlusIconImage />
    <input
      type="text"
      placeholder="Enter message..."
      className="font-semibold w-full bg-transparent outline-none ml-0 mr-auto text-gray-500 dark:text-gray-400 placeholder-gray-500 cursor-text"
    />
  </div>
);

export default MsgInput;
