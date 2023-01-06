import React from "react";

function Button({ text , onClick}) {
  return (
    <button type="button" className="w-full my-5 py-2 bg-blue-500 shadow-lg shadow-blue-500/50 hover:shadow-blue-500/40 text-white font-semibold rounded-lg" onClick={() => onClick()}>
      {text}
    </button>
  );
}

export default Button;
