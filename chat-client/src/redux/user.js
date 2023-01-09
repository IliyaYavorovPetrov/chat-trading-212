import { createSlice } from "@reduxjs/toolkit";

export const userSlice = createSlice({
    name: "user",
    initialState: {
        userUuid: "",
        nickname: "",
        email: "",
        pictureId: 0,
    },
    reducers: {
        updateUserUuid: (state, action) => {
            state.userUuid = action.payload;
        },
        updateNickname: (state, action) => {
            state.nickname = action.payload;
        },
        updateEmail: (state, action) => {
            state.email = action.payload;
        },
        updatePictureId: (state, action) => {
            state.pictureId = action.payload;
        },
    }
});

export const { updateUserUuid, updateNickname, updateEmail, updatePictureId } = userSlice.actions;
export default userSlice.reducer;