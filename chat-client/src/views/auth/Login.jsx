import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import Button from "./widgets/Button";
import { useDispatch } from "react-redux";
import { updateJwt } from "../../redux/jwt";
import ThemeIcon from "../../widgets/ThemeIcon";
import BigLogo from "../../widgets/BigLogo";
import ErrorPopup from "../popups/ErrorPopup";
import { updateUserUuid, updateEmail, updateNickname, updatePictureId } from "../../redux/user";

function Login() {
  const dispacth = useDispatch();
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const navigate = useNavigate();
  const [showError, setShowError] = useState(false);

  async function sendLoginRequest() {
    const registerBody = {
      email: email,
      password: password,
    };

    const response = await fetch("/login", {
      headers: {
        "Content-Type": "application/json",
      },
      method: "post",
      body: JSON.stringify(registerBody),
    });

    if (!response.ok) {
      setShowError(true);
      setTimeout(() => setShowError(false), 5000);
      return;
    }

    const data = await response.json();
    dispacth(updateJwt(data.jwtToken));
    dispacth(updateUserUuid(data.userUuid));
    dispacth(updateNickname(data.nickname));
    dispacth(updateEmail(data.email));
    dispacth(updatePictureId(data.pictureId));
    navigate("/home");
  }

  return (
    <div className="grid grid-cols-1 sm:grid-cols-1 h-screen w-full">
    {showError && (
        <ErrorPopup errorMsg="Wrong username or password" />
      )}
      <div className="dark:bg-gray-800 flex flex-col justify-center">
        <div className="fixed top-3 left-0">
          <ThemeIcon />
        </div>
        <div className="m-10">
          <BigLogo />
        </div>
        <form className="max-w-[400px] w-full mx-auto rounded-lg dark:bg-gray-900 shadow-2xl p-8 px-8">
          <h2 className="text-4xl dark:text-white font-bold text-center">
            Log in
          </h2>
          <div className="flex flex-col text-gray-400 py-2">
            <label>Email</label>
            <input
              className="rounded-lg dark:bg-gray-700 shadow-lg mt-2 p-2 focus:border-blue-500 focus:dark:bg-gray-800 focus:outline-none"
              type="text"
              value={email}
              onChange={(event) => setEmail(event.target.value)}
            />
          </div>
          <div className="flex flex-col text-gray-400 py-2">
            <label>Password</label>
            <input
              className="p-2 rounded-lg dark:bg-gray-700 shadow-lg mt-2 focus:border-blue-500 focus:dark:bg-gray-800 focus:outline-none"
              type="password"
              value={password}
              onChange={(event) => setPassword(event.target.value)}
            />
          </div>
          <div className="flex text-blue-500 py-2 justify-center underline">
            <p>
              <Link to="/register">Don't have an account?</Link>
            </p>
          </div>
          <Button text="Sign in" onClick={() => sendLoginRequest()} />
        </form>
      </div>
    </div>
  );
}

export default Login;
