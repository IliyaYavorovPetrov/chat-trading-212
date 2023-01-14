import { createSlice } from "@reduxjs/toolkit";

export const homeSlice = createSlice({
  name: "home",
  initialState: {
    showUserInfo: false,
    showAddFriends: false,
    isHomePressed: false,
    isAddGroupPressed: false,
    textGroupNameInput: "",
    urlGroupName: "",
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
      state.searchAddFriend = [];
    },
    updateIsHomePressed: (state, action) => {
      state.isHomePressed = action.payload;
    },
    updateIsAddGroupPressed: (state, action) => {
      state.isAddGroupPressed = action.payload;
    },
    updateTextGroupNameInput: (state, action) => {
      state.textGroupNameInput = action.payload;
    },
    updateUrlGroupName: (state, action) => {
      state.urlGroupName = action.payload;
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
  updateIsHomePressed,
  returnHomeToDefault,
  updateTextGroupNameInput,
  updateUrlGroupName,
  updateIsAddGroupPressed,
} = homeSlice.actions;
export default homeSlice.reducer;
