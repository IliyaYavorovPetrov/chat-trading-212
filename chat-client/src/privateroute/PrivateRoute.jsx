import React from "react";
import { useSelector } from "react-redux";
import { Navigate } from "react-router-dom";

function PrivateRoute({ children }) {
  const jwtToken = useSelector((state) => state.jwt.token);
  return jwtToken ? children : <Navigate to="/login"/>
}

export default PrivateRoute;
