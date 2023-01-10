import React from "react";

function DeleteAccountButton({ text , onClick}) {
  return (
    <button type="button" className="w-full mt-2 mb-2 py-2 bg-red-500 shadow-lg shadow-red-500/50 hover:shadow-red-500/40 text-white font-semibold rounded-lg" onClick={() => onClick()}>
      {text}
    </button>
  );
}

export default DeleteAccountButton;
