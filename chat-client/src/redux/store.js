import { configureStore } from "@reduxjs/toolkit";
import jwtReducer from './jwt';
import userReducer from './user';

export default configureStore({
    reducer: {
        jwt: jwtReducer,
        user: userReducer,
    }
});