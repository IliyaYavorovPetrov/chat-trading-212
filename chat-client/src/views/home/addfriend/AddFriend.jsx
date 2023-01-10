import React from "react";
import { BsPlus } from "react-icons/bs";
import { useDispatch, useSelector } from "react-redux";
import { useNavigate } from "react-router-dom";
import { returnHomeToDefault } from "../../../redux/home";
import { returnJwtToDefault } from "../../../redux/jwt";

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
    <div className="absolute top-1/3 left-1/3 flex-col grid grid-cols-1 sm:grid-cols-2 h-1/3 w-1/3 dark:bg-gray-600 bg-gray-400 rounded-lg">
      <div className="relative flex items-center justify-center">
        <img
          src={`https://robohash.org/${pictureId}?set=set2&size=240x240`}
          alt=""
          className="absolute w-4/5 h-4/5 rounded-full shadow-md object-cover dark:bg-gray-400 bg-gray-500 mb-auto mt-0 mx-0"
        />
      </div>
    </div>
  );
};

export default AddFriend;
