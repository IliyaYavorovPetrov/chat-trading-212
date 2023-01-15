import { createSlice } from "@reduxjs/toolkit";

export const homeSlice = createSlice({
  name: "home",
  initialState: {
    showUserInfo: false,
    showAddFriends: false,
    isHomePressed: true,
    isAddGroupPressed: false,
    textGroupNameInput: "",
    urlGroupName: "",
    isStart: true,
    isPrivatePressed: true,
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
    updateIsStart: (state, action) => {
      state.isStart = action.payload;
    },
    updateIsPrivatePressed: (state, action) => {
      state.isPrivatePressed = action.payload;
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
  updateIsStart,
  updateIsPrivatePressed,
  updateIsAddGroupPressed,
} = homeSlice.actions;
export default homeSlice.reducer;
