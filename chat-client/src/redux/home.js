import { createSlice } from "@reduxjs/toolkit";

export const homeSlice = createSlice({
    name: "home",
    initialState: {
        showUserInfo: false,
    },
    reducers: {
        updateShowUserInfo : (state, action) => {
            state.showUserInfo = action.payload;
        }
    }
});

export const { updateShowUserInfo } = homeSlice.actions;
export default homeSlice.reducer;