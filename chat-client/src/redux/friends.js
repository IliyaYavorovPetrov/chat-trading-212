import { createSlice } from "@reduxjs/toolkit";

export const friendsSlice = createSlice({
  name: "friends",
  initialState: {
    friends: [],
  },
  reducers: {
    updateFriends: (state, action) => {
      state.searchAddFriend.push(action.payload);
    },
    assignFriends: (state, action) => {
      state.searchAddFriend = action.payload;
    },
    clearFriends: (state) => {
      state.searchAddFriend = [];
    },
  },
});

export const {
    updateFriends,
    assignFriends,
    clearFriends,
} = friendsSlice.actions;
export default friendsSlice.reducer;
