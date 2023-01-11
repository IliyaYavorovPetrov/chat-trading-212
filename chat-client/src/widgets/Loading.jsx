import React from "react";
import { AiOutlineLoading3Quarters } from "react-icons/ai";

function Loading({ icon, onClick }) {
  return <AiOutlineLoading3Quarters className="w-10 h-10 animate-spin text-gray-200"/>;
}

export default Loading;
