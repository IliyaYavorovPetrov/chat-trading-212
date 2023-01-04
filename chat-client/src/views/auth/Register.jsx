import React from "react";
import { Link } from "react-router-dom"
import Button from "./widgets/Button";

function Register() {
    return (
      <div className='grid grid-cols-1 sm:grid-cols-1 h-screen w-full'>
          <div className='dark:bg-gray-800 flex flex-col justify-center'>
              <form className='max-w-[400px] w-full mx-auto rounded-lg dark:bg-gray-900 shadow-2xl p-8 px-8'>
                  <h2 className='text-4xl text-white font-bold text-center'>Register</h2>
                  <div className='flex flex-col text-gray-400 py-2'>
                      <label>Nickname</label>
                      <input className='rounded-lg dark:bg-gray-700 shadow-lg mt-2 p-2 focus:border-blue-500 focus:dark:bg-gray-800 focus:outline-none' type="text" />
                  </div>
                  <div className='flex flex-col text-gray-400 py-2'>
                      <label>Email</label>
                      <input className='rounded-lg dark:bg-gray-700 shadow-lg mt-2 p-2 focus:border-blue-500 focus:dark:bg-gray-800 focus:outline-none' type="text" />
                  </div>
                  <div className='flex flex-col text-gray-400 py-2'>
                      <label>Password</label>
                      <input className='p-2 rounded-lg dark:bg-gray-700 shadow-lg mt-2 focus:border-blue-500 focus:dark:bg-gray-800 focus:outline-none' type="password" />
                  </div>
                  <div className='flex text-blue py-2 justify-center underline'>
                      <p><Link to="/chat-trading212/login">Already have an account?</Link></p>
                  </div>

                  <Link to="/chat-trading212/home">
                    <Button text="Create Account" />
                  </Link>
              </form>
          </div>
      </div>
    )
  }
  
  export default Register;