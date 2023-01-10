import { createSlice } from "@reduxjs/toolkit";

export const jwtSlice = createSlice({
    name: "jwt",
    initialState: {
        token: "",
    },
    reducers: {
        updateJwt: (state, action) => {
            state.token = action.payload;
        },
        returnJwtToDefault: (state) => {
            state.token = "";
        }
    }
});

export const { updateJwt } = jwtSlice.actions;
export default jwtSlice.reducer;