import React, { useState } from "react";
import { FaSearch } from "react-icons/fa";
import { useDispatch, useSelector } from "react-redux";
import { clearSearchAddFriend, assignSearchAddFriend, updateTextGroupNameInput} from "../../../redux/home";

const NameGroupInput = () => {
  const dispatch = useDispatch();
  const jwtToken = useSelector((state) => state.jwt.token);
  const text = useSelector((state) => state.home.textGroupNameInput);
  
  async function createGroup() {
    
  }

  return (
    <div className="w-full flex items-center justify-start bg-gray-500 dark:bg-gray-600 dark:text-gray-400 text-gray-400 px-2 h-9 ml-0 mr-0 rounded-md shadow-md transition duration-300 ease-in-out">
      <input
        className="w-full font-sans font-semibold bg-transparent outline-none text-gray-640  placeholder-gray-400 pl-1 rounded"
        type="text"
        placeholder="Enter name of the group..."
        value={text}
        onChange={(event) => dispatch(updateTextGroupNameInput(event.target.value))}
      />

    </div>
  );
};

export default NameGroupInput;
