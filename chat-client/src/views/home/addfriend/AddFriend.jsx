import React, { useEffect, useState } from "react";
import { BsPlus } from "react-icons/bs";
import { useDispatch, useSelector } from "react-redux";
import { useNavigate } from "react-router-dom";
import { returnHomeToDefault } from "../../../redux/home";
import { returnJwtToDefault } from "../../../redux/jwt";
import CloseButton from "../../../widgets/CloseButton";
import AddFriendInput from "./widgets/AddFriendInput";
import Friend from "./widgets/Friend";

const AddFriend = () => {
  const dispatch = useDispatch();
  const updateSearchAddFriend = useSelector(
    (state) => state.home.searchAddFriend
  );
  const userUuid = useSelector((state) => state.user.userUuid);
  const [searchAddFriend, setSearchAddFriend] = useState();

  useEffect(() => {
    setSearchAddFriend(updateSearchAddFriend);
  }, [updateSearchAddFriend]);

  function giveAddFriendOptions() {
    return (
      <div>
        {searchAddFriend?.map((friend) => {
          if (friend.userUuid !== userUuid) {
            return (
              <Friend
                id={friend.userUuid}
                name={friend.nickname}
                pictureId={friend.pictureId}
                key={friend.userUuid}
              />
            );
          }
          return <div>No Users</div>;
        })}
      </div>
    );
  }

  return (
    <div className="absolute top-1/3 left-1/3 flex-col h-1/3 w-1/3 dark:bg-gray-800 bg-gray-400 rounded-lg">
      <div className="flex flex-col h-full">
        <div className="mt-0">
          <CloseButton
            icon={<BsPlus size="28" />}
            onClick={() => dispatch(returnHomeToDefault())}
          ></CloseButton>
        </div>
        <div className="mt-16">
          <AddFriendInput dispatch={dispatch} />
        </div>
        <div className="flex flex-col mt-2 bg-gray-400 dark:bg-gray-800 m-0 h-full w-full overflow-auto">
          {giveAddFriendOptions()}
        </div>
      </div>
    </div>
  );
};

export default AddFriend;
