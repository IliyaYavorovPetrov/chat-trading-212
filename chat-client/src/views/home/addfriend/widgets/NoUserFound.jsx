import { FaUserAstronaut } from "react-icons/fa";

const NoUserFound = () => {
    return (
      <div className="w-full h-full flex items-center justify-center py-1 px-1 m-0 font-bold dark:text-gray-400 :text-gray-600">
        <FaUserAstronaut />
        <h1>No Match</h1>
      </div>
    );
  };
  export default NoUserFound;
