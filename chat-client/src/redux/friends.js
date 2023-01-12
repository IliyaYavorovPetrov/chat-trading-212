import { createSlice } from "@reduxjs/toolkit";

export const friendsSlice = createSlice({
  name: "friends",
  initialState: {
    friends: [],
  },
  reducers: {
    updateFriends: (state, action) => {
      state.friends.push(action.payload);
    },
    assignFriends: (state, action) => {
      state.friends = action.payload;
    },
    clearFriends: (state) => {
      state.friends = [];
    },
  },
});

export const {
    updateFriends,
    assignFriends,
    clearFriends,
} = friendsSlice.actions;
export default friendsSlice.reducer;
