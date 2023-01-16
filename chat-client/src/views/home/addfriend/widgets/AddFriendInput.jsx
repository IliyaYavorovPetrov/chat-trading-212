import React, { useState } from "react";
import { FaSearch } from "react-icons/fa";
import { useDispatch, useSelector } from "react-redux";
import {
  clearSearchAddFriend,
  assignSearchAddFriend,
} from "../../../../redux/home";

const AddFriendInput = () => {
  const dispatch = useDispatch();
  const jwtToken = useSelector((state) => state.jwt.token);
  const isHomePressed = useSelector((state) => state.home.isHomePressed);
  const [search, setSearch] = useState("");

  async function sendUserInfoRequest() {
    dispatch(clearSearchAddFriend());
    var uuidRegex =
      /^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$/i;

    let response = null;
    debugger;
    if (isHomePressed) {
      if (uuidRegex.test(search)) {
        response = await fetch("/home/add/friends/uuid/" + search, {
          headers: {
            Authorization: "Bearer " + jwtToken,
            "Content-Type": "application/json",
          },
          method: "get",
        });

        if (!response.ok) {
          return;
        }
        const data = await response.json();
        console.log(data);
        var temp = [];
        temp.push(data);
        dispatch(assignSearchAddFriend(temp));
      } else {
        response = await fetch("/home/add/friends/nickname/" + search, {
          headers: {
            Authorization: "Bearer " + jwtToken,
            "Content-Type": "application/json",
          },
          method: "get",
        });

        if (!response.ok) {
          return;
        }
        const data = await response.json();
        console.log(data);
        dispatch(assignSearchAddFriend(data));
      }
    } else {
      if (uuidRegex.test(search)) {
        response = await fetch("/home/add/friends/uuid/" + search, {
          headers: {
            Authorization: "Bearer " + jwtToken,
            "Content-Type": "application/json",
          },
          method: "get",
        });
      } else {
        response = await fetch("/home/add/friends/nickname/" + search, {
          headers: {
            Authorization: "Bearer " + jwtToken,
            "Content-Type": "application/json",
          },
          method: "get",
        });
      }
    }
    // dispatch(assignSearchAddFriend(data));
  }

  return (
    <div>
      <div className="w-full flex items-center justify-start bg-gray-500 dark:bg-gray-600 dark:text-gray-400 text-gray-400 px-2 h-9 ml-0 mr-0 rounded-md shadow-md transition duration-300 ease-in-out">
        <input
          className="w-full font-sans font-semibold bg-transparent outline-none text-gray-640  placeholder-gray-400 pl-1 rounded"
          type="text"
          placeholder="Enter user id or nickname..."
          value={search}
          onChange={(event) => setSearch(event.target.value)}
        />
        <button type="button" onClick={() => sendUserInfoRequest()}>
          <FaSearch size="18" className="text-secondary my-auto" />
        </button>
      </div>
    </div>
  );
};

export default AddFriendInput;
