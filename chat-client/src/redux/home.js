import { createSlice } from "@reduxjs/toolkit";

export const homeSlice = createSlice({
    name: "home",
    initialState: {
        showUserInfo: false,
    },
    reducers: {
        updateShowUserInfo : (state, action) => {
            state.showUserInfo = action.payload;
        },
        returnHomeToDefault: (state) => {
            state.showUserInfo = false;
        }
    }
});

export const { updateShowUserInfo } = homeSlice.actions;
export default homeSlice.reducer;