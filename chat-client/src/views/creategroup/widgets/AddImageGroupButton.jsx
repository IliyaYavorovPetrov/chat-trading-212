import React, { useState } from "react";
import { BsPlusCircleFill } from "react-icons/bs";
import { useDispatch } from "react-redux";
import {
  updateTextGroupNameInput,
  updateUrlGroupName,
} from "../../../redux/home";

const AddImageGroupButton = () => {
  const dispatch = useDispatch();

  const [selectedFile, setSelectedFile] = useState();
  const [isFilePicked, setIsFilePicked] = useState(false);

  const uploadImage = (event) => {
    console.log(event.target.files[0].name);
    const data = new FormData();
    data.append("file", event.target.files[0]);
    data.append("upload_preset", "zps5pozv");
    data.append("cloud_name", "duiqnhfar");

    console.log("AddImgGroupButton");
    fetch(" https://api.cloudinary.com/v1_1/duiqnhfar/image/upload", {
      method: "post",
      body: data,
    })
      .then((resp) => resp.json())
      .then((data) => {
        console.log("Image url: " + data.url);
        dispatch(updateUrlGroupName(data.url));
      })
      .catch((err) => console.log(err));
  };

  return (
    <label
      htmlFor="file-upload-1"
      type="file"
      style={{
        backgroundImage: { BsPlusCircleFill },
      }}
    >
      <BsPlusCircleFill
        size="22"
        className="text-blue-500 dark:shadow-lg mx-2 dark:text-primary hover:scale-110 cursor-pointer"
      />
      <input
        type="file"
        id="file-upload-1"
        onChange={(event) => uploadImage(event)}
        style={{ display: "none" }}
      />
    </label>
  );
};

export default AddImageGroupButton;
