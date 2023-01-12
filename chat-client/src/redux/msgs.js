import { createSlice } from "@reduxjs/toolkit";

export const msgSlice = createSlice({
  name: "msgs",
  initialState: {
    msgs: [],
  },
  reducers: {
    updateMsgs: (state, action) => {
      state.msgs.push(action.payload);
    },
    assignMsgs: (state, action) => {
      state.msgs = action.payload;
    },
    clearMsgs: (state) => {
      state.msgs = [];
    },
  },
});

export const {
    updateMsgs,
    assignMsgs,
    clearMsgs,
} = msgSlice.actions;
export default msgSlice.reducer;
