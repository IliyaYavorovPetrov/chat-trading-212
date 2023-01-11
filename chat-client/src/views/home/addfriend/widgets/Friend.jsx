import AddFriendButton from "./AddFriendButton";

const Friend = ({ id, name, pictureId }) => {
    return (
      <div className="w-full flex flex-row items-center justify-start py-1 px-1 m-0">
        <div className="flex flex-col items-center w-12">
          <img
            src={`https://robohash.org/${1}?set=set2&size=180x180`}
            alt=""
            className="flex-none w-16 h-full rounded-full shadow-md object-cover dark:bg-gray-400 bg-gray-500 mb-0 mt-0 mx-0"
          />
        </div>
        <div className="w-full flex flex-col justify-start ml-4">
          <p className="text-left font-semibold text-sm text-gray-800 dark:text-white mr-2">
            #{id}
          </p>
          <p className="text-left font-normal text-sm text-gray-800 dark:text-white mr-2">
            Nickname: {name}
          </p>
        </div>
        <AddFriendButton text={"Add Friend"}/>
      </div>
    );
  };
  export default Friend;
