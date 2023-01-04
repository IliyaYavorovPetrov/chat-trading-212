import React from "react";
import useDarkMode from "../hooks/Theme";
import { FaMoon, FaSun } from "react-icons/fa";

function ThemeIcon() {
  const [darkTheme, setDarkTheme] = useDarkMode();
  const handleMode = () => setDarkTheme(!darkTheme);
  return (
    <span onClick={handleMode}>
      {darkTheme ? (
        <FaSun size="24" className="top-navigation-icon" />
      ) : (
        <FaMoon size="24" className="top-navigation-icon" />
      )}
    </span>
  );
}

export default ThemeIcon;
