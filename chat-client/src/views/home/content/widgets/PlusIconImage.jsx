import React, { useState } from "react";
import { BsPlusCircleFill } from "react-icons/bs";
import { CloudinaryContext } from "cloudinary-react";

const PlusIconImage = () => {
  const [image, setImage] = useState("");
  const [url, setUrl] = useState("");

  const uploadImage = () => {
    const data = new FormData();
    data.append("file", image);
    data.append("upload_preset", "qewwcqzi");
    data.append("cloud_name", "dixr3fcy8");
    fetch(" https://api.cloudinary.com/v1_1/dixr3fcy8/image/upload", {
      method: "post",
      body: data,
    })
      .then((resp) => resp.json())
      .then((data) => {
        console.log("Image url: " + data.url);
        setUrl(data.url);
        console.log("Image url: " + data.url);
      })
      .catch((err) => console.log(err));
  };

  return (
    // <input type="file" onChange={(e) => setImage(e.target.files[0])}>
      <button type="button" onClick={() => uploadImage()}>
        <BsPlusCircleFill
          size="22"
          className="text-blue-500 dark:shadow-lg mx-2 dark:text-primary hover:scale-110 cursor-pointer"
        />
      </button>
    // </input>
  );
};

export default PlusIconImage;
