import React from "react";

const Msg = ({ name, pictureId, timestamp, text }) => {
  return (
    <div className="w-full flex flex-row items-center justify-start py-4 px-8 m-0 cursor-pointer">
      <div className="flex flex-col items-center w-12">
        <img
          src={`https://robohash.org/${pictureId}?set=set2&size=180x180`}
          alt=""
          className="flex-none w-14 h-full rounded-full shadow-md object-cover dark:bg-gray-400 bg-gray-500 mb-auto mt-0 mx-0 cursor-pointer"
        />
      </div>
      <div className="w-4/5 flex flex-col justify-start ml-4">
        <p className="text-left font-bold underline text-gray-800 dark:text-white mr-2 cursor-pointer">
          {name}
          {/* <small className="text-xs text-left font-semibold text-gray-500 dark:text-gray-600 ml-2">
              {timestamp}
            </small> */}
        </p>
        <p className="text-lg text-left text-gray-800 dark:text-white mr-auto whitespace-normal">
          {text}
        </p>
      </div>
    </div>
  );
};
export default Msg;
