import React from "react";
import PlusIconImage from "./PlusIconImage";

const MsgInput = () => (
  <div className="flex flex-row items-center justify-between fixed left-88 right-8 bottom-0 rounded-lg shadow-lg bg-gray-400 dark:bg-gray-700 px-2 h-12">
    <PlusIconImage />
    <input
      className="w-full font-sans font-semibold bg-transparent outline-none text-gray-400 placeholder-gray-500 pl-1 rounded"
      type="text"
      placeholder="Enter message..."
    />
  </div>
);

export default MsgInput;
