import React from "react";
import { Route, Routes } from "react-router-dom"
import Register from "./views/auth/Register";
import Login from "./views/auth/Login";

function App() {
  return (
    <div>
      <Login />
      {/* <Routes>
        <Route path="/chat-trading212">
          <Route path="/login" element={<Login />} />
          <Route path="/register" element={<Register />} />
        </Route>
      </Routes> */}
    </div>
  );
}

export default App;
