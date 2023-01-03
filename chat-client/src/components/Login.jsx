import React from "react";

function Login() {
    return (
      <div className='grid grid-cols-1 sm:grid-cols-1 h-screen w-full'>
          <div className='bg-gray-800 flex flex-col justify-center'>
              <form className='max-w-[400px] w-full mx-auto rounded-lg bg-gray-900 p-8 px-8'>
                  <h2 className='text-4xl text-white font-bold text-center'>Log in</h2>
                  <div className='flex flex-col text-gray-400 py-2'>
                      <label>Email</label>
                      <input className='rounded-lg bg-gray-700 mt-2 p-2 focus:border-blue-500 focus:bg-gray-800 focus:outline-none' type="text" />
                  </div>
                  <div className='flex flex-col text-gray-400 py-2'>
                      <label>Password</label>
                      <input className='p-2 rounded-lg bg-gray-700 mt-2 focus:border-blue-500 focus:bg-gray-800 focus:outline-none' type="password" />
                  </div>
                  <div className='flex text-teal-500 py-2 justify-center underline'>
                      <p>Already have an account?</p>
                  </div>
                  <button className='w-full my-5 py-2 bg-teal-500 shadow-lg shadow-teal-500/50 hover:shadow-teal-500/40 text-white font-semibold rounded-lg'>Sign in</button>
              </form>
          </div>
      </div>
    )
  }
  
  export default Login;