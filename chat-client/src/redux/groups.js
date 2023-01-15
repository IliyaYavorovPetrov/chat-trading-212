import { createSlice } from "@reduxjs/toolkit";

export const groupSlice = createSlice({
  name: "group",
  initialState: {
    groups: [],
  },
  reducers: {
    assignGroups: (state, action) => {
      console.log("hit assignGroups");
      state.groups = action.payload;
    },
  },
});

export const { assignGroups } = groupSlice.actions;
export default groupSlice.reducer;
