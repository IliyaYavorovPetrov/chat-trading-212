import { configureStore } from "@reduxjs/toolkit";
import jwtReducer from './jwt';
import userReducer from './user';
import homeReducer from './home';
import friendsReducer from './friends';

export default configureStore({
    reducer: {
        jwt: jwtReducer,
        user: userReducer,
        home: homeReducer,
        friends: friendsReducer,
    }
});