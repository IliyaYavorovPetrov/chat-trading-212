import React from "react";

function AddFriendButton({ text, onClick }) {
  return (
    <button
      type="button"
      className="w-1/3 mt-0 mb-2 mr-2 p-2 bg-green-500 shadow-lg shadow-green-500/50 hover:shadow-green-500/40 text-white font-semibold rounded-lg cursor-pointer"
      onClick={() => onClick()}
    >
      {text}
    </button>
  );
}

export default AddFriendButton;
