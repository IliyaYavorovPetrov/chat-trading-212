import React from "react";
import Active from "./Active";
import Unactive from "./Unactive";

const Status = ({isActive}) => {
  return <div>
    {isActive && <Active />}
    {!isActive && <Unactive />}
  </div>
};

export default Status;
