import { configureStore } from "@reduxjs/toolkit";
import jwtReducer from './jwt';
import userReducer from './user';
import homeReducer from './home';

export default configureStore({
    reducer: {
        jwt: jwtReducer,
        user: userReducer,
        home: homeReducer,
    }
});