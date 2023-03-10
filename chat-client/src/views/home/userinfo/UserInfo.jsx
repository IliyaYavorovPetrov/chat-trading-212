import React, { useState } from "react";
import { BsPlus } from "react-icons/bs";
import { useDispatch, useSelector } from "react-redux";
import { useNavigate } from "react-router-dom";
import { returnHomeToDefault } from "../../../redux/home";
import { returnJwtToDefault } from "../../../redux/jwt";
import { updateEmail } from "../../../redux/user";
import CloseButton from "../../../widgets/CloseButton";
import DeleteAccountButton from "./widgets/DeleteAccountButton";
import LogOutButton from "./widgets/LogOutButton";

const UserInfo = () => {
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
    <div className="absolute top-1/3 left-1/3 flex-col grid grid-cols-1 sm:grid-cols-2 h-96 dark:bg-gray-700 bg-gray-400 rounded-lg">
      <div className="relative flex items-center justify-center">
        <img
          src={`https://robohash.org/${pictureId}?set=set2&size=240x240`}
          alt=""
          className="absolute w-4/5 h-4/5 rounded-full shadow-md object-cover dark:bg-gray-400 bg-gray-500 mb-auto mt-0 mx-0"
        />
      </div>
      <CloseButton
        icon={<BsPlus size="28" />}
        onClick={() => dispatch(returnHomeToDefault())}
      ></CloseButton>
      <div className="flex flex-row">
        <div className="w-full mt-20 mb-2 p-2">
          <div className="flex flex-col justify-center dark:text-gray-400 text-gray-600 py-2 text-lg font-medium ">
            <label>ID: {userUuid}</label>
            <label>Emial: {email}</label>
            <label>Nickname: {nickname}</label>
            <LogOutButton
              text="Log Out"
              onClick={() => {
                dispatch(returnJwtToDefault());
              }}
            />
            <DeleteAccountButton
              text="Delete Account"
              onClick={() => deleteUser()}
            />
          </div>
        </div>
      </div>
    </div>
  );
};

export default UserInfo;
