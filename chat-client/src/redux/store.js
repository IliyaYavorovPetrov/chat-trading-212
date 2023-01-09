import { configureStore } from "@reduxjs/toolkit";
import jwtReducer from './jwt';

export default configureStore({
    reducer: {
        jwt: jwtReducer
    }
});