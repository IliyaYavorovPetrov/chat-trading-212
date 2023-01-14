import React, { useState } from "react";
import { BsPlusCircleFill } from "react-icons/bs";

const PlusIconImage = () => {
  const [selectedFile, setSelectedFile] = useState();
  const [isFilePicked, setIsFilePicked] = useState(false);

  const upload = (event) => {
    console.log(event.target.files[0].name);
    const data = new FormData();
    data.append("file", event.target.files[0]);
    data.append("upload_preset", "zps5pozv");
    data.append("cloud_name", "duiqnhfar");

    fetch(" https://api.cloudinary.com/v1_1/duiqnhfar/image/upload", {
      method: "post",
      body: data,
    })
      .then((resp) => resp.json())
      .then((data) => {
        console.log("Image url: " + data.url);
      })
      .catch((err) => console.log(err));
  };

  // const sendURLToServer = (eventId, userId, url) => {
  //   fetch(" http://localhost:8080/events/1/images", {
  //     method: "put",
  //     headers: {
  //       "Content-Type": "application/json",
  //     },
  //     body: JSON.stringify({
  //       eventId: eventId,
  //       userId: userId,
  //       url: url,
  //     }),
  //   })
  //     .then(console.log("request send"))
  //     .catch((err) => console.log(err));
  // };

  return (
    // <label
    //   htmlFor="file-upload"
    //   type="file"
    //   style={{
    //     backgroundImage: { BsPlusCircleFill },
    //   }}
    // >
    //   <BsPlusCircleFill
    //     size="22"
    //     className="text-blue-500 dark:shadow-lg mx-2 dark:text-primary hover:scale-110 cursor-pointer"
    //   />
    //   <input
    //     type="file"
    //     id="file-upload"
    //     onChange={console.log("a")}
    //     style={{ display: "none" }}
    //   />
    // </label>
    <div></div>
  );
};

export default PlusIconImage;
