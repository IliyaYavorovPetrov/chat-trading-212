import React from "react";
import Status from "./Status";

const FriendBar = ({ pictureId, name, isActive}) => {
    return (
      <div className="flex flex-row items-center justify-start py-1 px-1 m-0 ml-16">
        <div className="flex flex-col items-center w-16">
          <img
            src={`https://robohash.org/${pictureId}?set=set2&size=180x180`}
            alt=""
            className="flex-none w-16 h-full rounded-full shadow-md object-cover dark:bg-gray-400 bg-gray-500 mb-0 mt-0 mx-0"
          />
        </div>
        <div className="w-full flex flex-col justify-start ml-4">
          <p className="text-left font-bold text-base text-gray-800 dark:text-white">
            {name}
          </p>
        </div>
        <Status isActive={isActive}/>
      </div>
    );
  };
  export default FriendBar;
