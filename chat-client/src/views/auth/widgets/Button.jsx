import React from "react";

function Button({ text }) {
    return (
        <button className='w-full my-5 py-2 bg-blue shadow-lg shadow-blue/50 hover:shadow-blue/40 text-white font-semibold rounded-lg'>{text}</button>
    )
}

export default Button;