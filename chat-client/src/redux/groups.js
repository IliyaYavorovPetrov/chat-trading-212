import { createSlice } from "@reduxjs/toolkit";

export const groupSlice = createSlice({
  name: "group",
  initialState: {
    currGroupUuid: "",
    groups: [],
  },
  reducers: {
    assignCurrentGroupId: (state, action) => {
      state.currGroupUuid = action.payload;
    },
    assignGroups: (state, action) => {
      state.groups = action.payload;
    },
  },
});

export const { assignCurrentGroupId, assignGroups } = groupSlice.actions;
export default groupSlice.reducer;
