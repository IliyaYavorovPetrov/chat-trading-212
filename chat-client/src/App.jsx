import React from "react";
import { Route, Routes } from "react-router-dom"
import Register from "./views/auth/Register";
import Login from "./views/auth/Login";

function App() {
  return (
    <div>
      <Routes>
        <Route path="/chat-trading212/login" element={<Login />} />
        <Route path="/chat-trading212/register" element={<Register />} />
      </Routes>
    </div>
  );
}

export default App;
