import React, { useEffect, useState } from "react";
import { Link, redirect, useNavigate } from "react-router-dom";
import Button from "./widgets/Button";

import ThemeIcon from "../../widgets/ThemeIcon";
import BigLogo from "../../widgets/BigLogo";
import useLocalStorage from "../../hooks/LocalStorage";

function Register() {
  const [jwt, setJwt] = useLocalStorage("", "jwt");
  const [nickname, setNickname] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  function sendRegisterRequest() {
    const registerBody = {
      nickname: nickname, 
      email: email,
      password: password,
    };

    fetch("/register", {
      headers: {
        "Content-Type": "application/json",
      },
      method: "post",
      body: JSON.stringify(registerBody),
    })
      .then((response) => Promise.all([response.json(), response.headers]))
      .then(([body, headers]) => {
        setJwt(headers.get("authorization"));
        setNickname("")
        setEmail("");
        setPassword("");

        if (body.hasOwnProperty("token")) {
          redirect("/home");
        }
      });
  }

  return (
    <div className="grid grid-cols-1 sm:grid-cols-1 h-screen w-full">
      <div className="dark:bg-gray-800 flex flex-col justify-center">
        <div className="fixed top-3 left-0">
          <ThemeIcon />
        </div>
        <div className="m-10">
          <BigLogo />
        </div>
        <form className="max-w-[400px] w-full mx-auto rounded-lg dark:bg-gray-900 shadow-2xl p-8 px-8">
          <h2 className="text-4xl dark:text-white font-bold text-center">
            Register
          </h2>
          <div className="flex flex-col text-gray-400 py-2">
            <label>Nickname</label>
            <input
              className="rounded-lg dark:bg-gray-700 shadow-lg mt-2 p-2 focus:border-blue-500 focus:dark:bg-gray-800 focus:outline-none"
              type="text"
              value={nickname}
              onChange={(event) => setNickname(event.target.value)}
            />
          </div>
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
              <Link to="/login">Already have an account?</Link>
            </p>
          </div>
          <Button text="Register" onClick={() => sendRegisterRequest()} />
        </form>
      </div>
    </div>
  );
}

export default Register;