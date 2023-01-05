import TopNavigation from "./TopNavigation";
import { BsPlusCircleFill } from "react-icons/bs";
// import { useState } from 'react';

const ContentContainer = () => {
  return (
    <div className="lex flex-col bg-gray-300 dark:bg-gray-700 m-0 h-full w-full overflow-hidden">
      <TopNavigation />
      <div className="flex flex-col items-center h-full w-full mt-0 ml-0 mx-auto px-0 pb-12 overflow-y-scroll">
        <Post
          name="Ada"
          timestamp="one week ago"
          text={`Lorem ipsum dolor sit amet consectetur adipisicing elit. Lorem ipsum dolor sit
          amet consectetur adipisicing elit. Lorem ipsum dolor sit amet consectetur
          adipisicing elit. Lorem ipsum dolor sit amet consectetur adipisicing elit. Lorem
          ipsum dolor sit amet consectetur adipisicing elit.`}
        />
        <Post
          name="Leon"
          timestamp="one week ago"
          text={`Lorem ipsum dolor. `}
        />
        <Post name="Jill" timestamp="5 days ago" text={`Lorem.`} />
        <Post
          name="Ellie"
          timestamp="4 days ago"
          text={`Lorem ipsum dolor sit amet consectetur adipisicing elit. `}
        />
        <Post
          name="Chris"
          timestamp="4 days ago"
          text={`Lorem ipsum dolor sit amet consectetur adipisicing elit. Lorem ipsum dolor sit
          amet consectetur adipisicing elit. Lorem ipsum dolor sit amet consectetur
          adipisicing elit. Lorem ipsum dolor sit amet consectetur adipisicing elit. Lorem
          ipsum dolor sit amet consectetur adipisicing elit.
          
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Lorem
          ipsum dolor sit amet consectetur adipisicing elit.`}
        />
        <Post
          name="Claire"
          timestamp="2 days ago"
          text={`Lorem ipsum dolor sit amet consectetur adipisicing elit. Lorem ipsum dolor sit
          amet consectetur adipisicing elit. Lorem ipsum dolor sit amet consectetur
          adipisicing elit. Lorem ipsum dolor sit amet consectetur adipisicing elit. `}
        />
        <Post
          name="Albert"
          timestamp="22 hours ago"
          text={`Lorem ipsum dolor sit amet consectetur adipisicing elit. ☺️ `}
        />
        <Post
          name="Rebecca"
          timestamp="3 hours ago"
          text={`Lorem ipsum dolor sit amet consectetur adipisicing elit. Lorem ipsum dolor sit
          amet consectetur adipisicing elit.`}
        />
        <Post
          name="H.U.N.K"
          timestamp="Just now"
          text={`Lorem ipsum dolor sit amet consectetur adipisicing elit. Lorem ipsum dolor sit
          amet consectetur adipisicing elit. Lorem ipsum dolor sit amet consectetur
          adipisicing elit. Lorem ipsum dolor sit amet consectetur adipisicing elit. Lorem
          ipsum dolor sit amet consectetur adipisicing elit.`}
        />
      </div>
      <BottomBar />
    </div>
  );
};

const BottomBar = () => (
  <div className="flex flex-row items-center justify-between fixed left-88 right-8 bottom-2 rounded-lg shadow-lg bg-gray-400 dark:bg-gray-600 px-2 h-12">
    <PlusIcon />
    <input
      type="text"
      placeholder="Enter message..."
      className="font-semibold w-full bg-transparent outline-none ml-0 mr-auto text-gray-500  dark:text-gray-400 placeholder-gray-500 cursor-text"
    />
  </div>
);

const Post = ({ name, timestamp, text }) => {
  const seed = Math.round(Math.random() * 100);
  return (
    <div className="w-full flex flex-row items-center justify-evenly py-4 px-8 m-0 cursor-pointer">
      <div className="lex flex-col items-center w-12 m-0 ml-auto mb-auto">
        <img
          src={`https://robohash.org/${seed}?set=set2&size=180x180`}
          alt=""
          className="avatar"
        />
      </div>

      <div className="w-4/5 flex flex-col justify-start ml-auto">
        <p className="text-left font-semibold text-gray-800 dark:text-white mr-2 cursor-pointer">
          {name}
          <small className="text-xs text-left font-semibold text-gray-500 dark:text-gray-600 ml-2">
            {timestamp}
          </small>
        </p>
        <p className="ext-lg text-left text-gray-800 dark:text-white mr-auto whitespace-normal">
          {text}
        </p>
      </div>
    </div>
  );
};

const PlusIcon = () => (
  <BsPlusCircleFill
    size="22"
    className="text-blue-500 dark:shadow-lg mx-2 dark:text-primary"
  />
);

export default ContentContainer;