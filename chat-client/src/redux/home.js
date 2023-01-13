import { createSlice } from "@reduxjs/toolkit";

export const homeSlice = createSlice({
  name: "home",
  initialState: {
    showUserInfo: false,
    showAddFriends: false,
    searchAddFriend: [],
  },
  reducers: {
    updateShowUserInfo: (state, action) => {
      state.showUserInfo = action.payload;
    },
    updateAddFriend: (state, action) => {
      state.showAddFriends = action.payload;
    },
    updateSearchAddFriend: (state, action) => {
      state.searchAddFriend.push(action.payload);
    },
    assignSearchAddFriend: (state, action) => {
      state.searchAddFriend = action.payload;
    },
    clearSearchAddFriend: (state) => {
      console.log("kura na maika ti");
      state.searchAddFriend = [];
    },
    returnHomeToDefault: (state) => {
      state.showUserInfo = false;
      state.showAddFriends = false;
    },
  },
});

export const {
  updateShowUserInfo,
  updateAddFriend,
  updateSearchAddFriend,
  assignSearchAddFriend,
  clearSearchAddFriend,
  returnHomeToDefault,
} = homeSlice.actions;
export default homeSlice.reducer;
