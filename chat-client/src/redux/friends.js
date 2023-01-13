import { createSlice } from "@reduxjs/toolkit";
import { act } from "react-dom/test-utils";

export const friendsSlice = createSlice({
  name: "friends",
  initialState: {
    friends: [],
  },
  reducers: {
    updateFriends: (state, action) => {
      const jsonFriend = JSON.stringify(action.payload);

      console.log(jsonFriend[0]);
      jsonFriend = jsonFriend[0];
      const friendBody = {
        friendshipUuid: jsonFriend.friendshipUuid,
        userUuid: jsonFriend.userUuid,
        userNickname: jsonFriend.userNickname,
        userPictureId: jsonFriend.userPictureId,
      };
      console.log(jsonFriend);

      state.friends.push(friendBody);
    },
    assignFriends: (state, action) => {
      state.friends = action.payload;
    },
    clearFriends: (state) => {
      state.friends = {};
    },
  },
});

export const {
    updateFriends,
    assignFriends,
    clearFriends,
} = friendsSlice.actions;
export default friendsSlice.reducer;
