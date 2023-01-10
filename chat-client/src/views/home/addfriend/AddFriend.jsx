import React from "react";
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
  const jwtToken = useSelector((state) => state.jwt.token);
  const userUuid = useSelector((state) => state.user.userUuid);
  const nickname = useSelector((state) => state.user.nickname);
  const email = useSelector((state) => state.user.email);
  const pictureId = useSelector((state) => state.user.pictureId);

  const navigate = useNavigate();

  async function deleteUser() {
    const deleteUserBody = {
      jwtToken: jwtToken,
      userUuid: userUuid,
      nickname: nickname,
      email: email,
      pictureId: pictureId,
      isDeleted: false,
    };

    const response = await fetch("/home/personal/info/delete", {
      headers: {
        "Content-Type": "application/json",
      },
      method: "post",
      body: JSON.stringify(deleteUserBody),
    });

    if (!response.ok) {
      return;
    }

    navigate("/login");
  }

  return (
    <div className="absolute top-1/3 left-1/3 flex-col h-1/3 w-1/3 dark:bg-gray-600 bg-gray-400 rounded-lg">
      <div className="flex flex-col h-full">
        <div className="mt-0">
          <CloseButton
            icon={<BsPlus size="28" />}
            onClick={() => dispatch(returnHomeToDefault())}
          ></CloseButton>
        </div>
        <div className="mt-16">
          <AddFriendInput />
        </div>
        <div className="flex flex-col mt-2 bg-gray-400 dark:bg-gray-600 m-0 h-full w-full overflow-auto">
            <Friend id={"a1184094-820d-431c-a14d-5b84ee66b388"} name={"b"}/>
            <Friend id={"a1184094-820d-431c-a14d-5b84ee66b388"} name={"b"}/>
            <Friend id={"a1184094-820d-431c-a14d-5b84ee66b388"} name={"b"}/>
            <Friend id={"a1184094-820d-431c-a14d-5b84ee66b388"} name={"b"}/>
            <Friend id={"a1184094-820d-431c-a14d-5b84ee66b388"} name={"b"}/>
            <Friend id={"a1184094-820d-431c-a14d-5b84ee66b388"} name={"b"}/>
        </div>
      </div>
    </div>
  );
};

export default AddFriend;
