import React from "react";

function LogOutButton({ text , onClick}) {
  return (
    <button type="button" className="w-full mt-20 mb-2 p-2 bg-blue-500 shadow-lg shadow-blue-500/50 hover:shadow-blue-500/40 text-white font-semibold rounded-lg" onClick={() => onClick()}>
      {text}
    </button>
  );
}

export default LogOutButton;
