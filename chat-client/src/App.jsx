import React from "react";
import { Route, Routes } from "react-router-dom";
import Register from "./views/auth/Register";
import Login from "./views/auth/Login";
import Home from "./views/home/Home";

function App() {
  return (
    <div>
      <Routes>
        <Route path="/chat-trading212/login" element={<Login />} />
        <Route path="/chat-trading212/register" element={<Register />} />
        <Route path="/chat-trading212/home" element={<Home />} />
      </Routes>
    </div>
  );
}

export default App;
