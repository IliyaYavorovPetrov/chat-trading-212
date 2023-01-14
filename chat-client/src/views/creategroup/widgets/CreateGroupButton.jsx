import React from "react";

const CreateGroupButton = ({text, groupName, url}) => {
  async function createGroup(groupName, url) {
    if (groupName === "") {
      return;
    }
    if (url === "") {
      return;
    }

    console.log();
  }

  return (
    <button
      type="button"
      className="w-3/5 my-5 py-2 bg-blue-500 shadow-lg shadow-blue-500/50 hover:shadow-blue-500/40 text-white font-semibold rounded-lg"
      onClick={() => createGroup()}
    >
      {text}
    </button>
  );
};

export default CreateGroupButton;
