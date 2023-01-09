import React from "react";
import { FaSearch } from "react-icons/fa";

const Search = () => (
  <div className="w-1/5 flex items-center justify-start bg-gray-400 dark:bg-gray-600 dark:text-gray-400 px-2 h-9 ml-0 mr-0 rounded-md shadow-md transition duration-300 ease-in-out">
    <input
      className="w-full font-sans font-semibold bg-transparent outline-none text-gray-640  placeholder-gray-500 pl-1 rounded"
      type="text"
      placeholder="Search..."
    />
    <FaSearch size="18" className="text-secondary my-auto" />
  </div>
);

export default Search;
