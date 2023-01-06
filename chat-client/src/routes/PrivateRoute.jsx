import React from "react";
import { Navigate } from "react-router-dom";
import useLocalStorage from "../hooks/LocalStorage";

const PrivateRoute = ({children}) => {
    const [jwt, setJwt] = useLocalStorage("", "jwt");
    return jwt ? children : <Navigate to="/login"/>
};

export default PrivateRoute;