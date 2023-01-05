import React from "react";
import useDarkMode from "../hooks/Theme";
import { FaMoon, FaSun } from "react-icons/fa";

function ThemeIcon() {
  const [darkTheme, setDarkTheme] = useDarkMode();
  const handleMode = () => setDarkTheme(!darkTheme);
  return (
    <span onClick={handleMode}>
      {darkTheme ? (
        <FaSun
          size="24"
          className="text-gray-500 mr-3 ml-4 transition duration-300 ease-in-out hover:text-blue-400 cursor-pointer"
        />
      ) : (
        <FaMoon
          size="24"
          className="text-gray-500 mr-3 ml-4 transition duration-300 ease-in-out hover:text-blue-400 cursor-pointer"
        />
      )}
    </span>
  );
}

export default ThemeIcon;
