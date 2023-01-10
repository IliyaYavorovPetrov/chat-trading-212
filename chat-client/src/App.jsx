import React from "react";
import { Route, Routes } from "react-router-dom";
import Register from "./views/auth/Register";
import Login from "./views/auth/Login";
import Home from "./views/home/Home";
import PrivateRoute from "./privateroute/PrivateRoute";

function App() {
  return (
    <div>
      <Routes>
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route
          path="/home"
          element={
            <PrivateRoute>
              <Home />
            </PrivateRoute>
          }
        />
      </Routes>
    </div>
  );
}

export default App;
