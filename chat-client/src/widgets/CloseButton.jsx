import React from "react";

function CloseButton({ icon, onClick }) {
  return (
    <button className="fixed" type="button" onClick={() => onClick()}>
      <div className="flex justify-center items-center transform w-10 h-10 mt-2 ml-2 dark:bg-gray-700 bg-gray-600 text-white hover:scale-110 hover:dark:bg-red-500 hover:bg-red-500 hover:rotate-45 rounded-3xl transition-all duration-300">
        {icon}
      </div>
    </button>
  );
}

export default CloseButton;
