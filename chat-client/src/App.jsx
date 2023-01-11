import React from "react";
import { Route, Routes } from "react-router-dom";
import Register from "./views/auth/Register";
import Login from "./views/auth/Login";
import Home from "./views/home/Home";
import PrivateRoute from "./privateroute/PrivateRoute";
import SockJsClient from 'react-stomp';

function App() {
  return (
    <div>
      <SockJsClient 
        url="http://localhost:8080/ws-message"
        topics={['/topic/message']}
        onConnect={() => console.log("Connected!!")}
        onDisconnect={() => console.log("Disconnected!")}
        onMessage={(data) => console.log(data)}
        debug={false}
      />

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
