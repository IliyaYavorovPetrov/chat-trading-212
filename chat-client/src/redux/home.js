import { createSlice } from "@reduxjs/toolkit";

export const homeSlice = createSlice({
    name: "home",
    initialState: {
        showUserInfo: false,
        showAddFriends: false,
    },
    reducers: {
        updateShowUserInfo : (state, action) => {
            state.showUserInfo = action.payload;
        },
        updateAddFriend : (state, action) => {
            state.showAddFriends = action.payload;
        },
        returnHomeToDefault: (state) => {
            state.showUserInfo = false;
            state.showAddFriends = false;
        }
    }
});

export const { updateShowUserInfo, updateAddFriend, returnHomeToDefault } = homeSlice.actions;
export default homeSlice.reducer;