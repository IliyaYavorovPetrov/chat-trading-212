import { click } from "@testing-library/user-event/dist/click";
import React, { useEffect, useState } from "react";
import { BsPlus } from "react-icons/bs";
import { useDispatch, useSelector } from "react-redux";
import { useNavigate } from "react-router-dom";
import { clearSearchAddFriend, returnHomeToDefault } from "../../../redux/home";
import { returnJwtToDefault } from "../../../redux/jwt";
import CloseButton from "../../../widgets/CloseButton";
import AddFriendInput from "./widgets/AddFriendInput";
import Friend from "./widgets/Friend";
import NoUserFound from "./widgets/NoUserFound";

const AddFriend = () => {
  const dispatch = useDispatch();
  const updateSearchAddFriend = useSelector(
    (state) => state.home.searchAddFriend
  );
  const jwtToken = useSelector((state) => state.jwt.token);
  const userUuid = useSelector((state) => state.user.userUuid);
  const nickname = useSelector((state) => state.user.nickname);
  const pictureId = useSelector((state) => state.user.pictureId);
  const isHomePressed = useSelector((state) => state.home.isHomePressed);
  const groupId = useSelector((state) => state.group.currGroupUuid);

  const [searchAddFriend, setSearchAddFriend] = useState();

  useEffect(() => {
    setSearchAddFriend(updateSearchAddFriend);
  }, [updateSearchAddFriend]);

  async function sendFriendRequest(
    friendUserUuid,
    friendNickname,
    friendPictureId
  ) {
    if (isHomePressed) {
      const requestFriendship = {
        userUuid: userUuid,
        userNickname: nickname,
        userPictureId: pictureId,
        friendUuid: friendUserUuid,
        friendNickname: friendNickname,
        friendPictureId: friendPictureId,
      };
      const response = await fetch("/home/friends", {
        headers: {
          Authorization: "Bearer " + jwtToken,
          "Content-Type": "application/json",
        },
        method: "post",
        body: JSON.stringify(requestFriendship),
      });
    } else {
      const reqGroupAdd = {
        groupUuid: groupId,
        userUuid: friendUserUuid,
        userNickname: friendNickname,
        userPictureId: friendPictureId,
      };

      const response = await fetch("home/groups/add", {
        headers: {
          Authorization: "Bearer " + jwtToken,
          "Content-Type": "application/json",
        },
        method: "post",
        body: JSON.stringify(reqGroupAdd),
      });
    }
  }

  function giveAddFriendOptions() {
    return (
      <div>
        { searchAddFriend?.map((friend) => {
          if (friend.userUuid !== userUuid) {
            return (
              <Friend
                id={friend.userUuid}
                name={friend.nickname}
                pictureId={friend.pictureId}
                key={friend.userUuid}
                onClick={() => {
                  sendFriendRequest(
                    friend.userUuid,
                    friend.nickname,
                    friend.pictureId
                  );
                }}
              />
            );
          }
          return <NoUserFound />;
        })

        }
        {searchAddFriend.length === 0 && <NoUserFound />}
      </div>
    );
  }

  return (
    <div className="absolute top-1/3 left-1/3 flex-col h-1/3 w-1/3 dark:bg-gray-800 bg-gray-400 rounded-lg">
      <div className="flex flex-col h-full">
        <div className="mt-0">
          <CloseButton
            icon={<BsPlus size="28" />}
            onClick={() => {
              dispatch(returnHomeToDefault());
              dispatch(clearSearchAddFriend());
              setSearchAddFriend("");
            }}
          ></CloseButton>
        </div>
        <div className="mt-16">
          <AddFriendInput />
        </div>
        <div className="flex flex-col mt-2 bg-gray-400 dark:bg-gray-800 m-0 h-full w-full overflow-auto">
          {giveAddFriendOptions()}
        </div>
      </div>
    </div>
  );
};

export default AddFriend;
