import React from "react";

function ErrorPopup({ errorMsg }) {
    return <div class="fixed inset-0 z-10">
    <div class="relative max-w-md mx-auto flex items-center justify-center px-6 py-4 bg-red-600 rounded-lg shadow-xl">
      <div class="text-center font-semibold text-white">
        {errorMsg}
      </div>
    </div>
  </div>
}

export default ErrorPopup;
