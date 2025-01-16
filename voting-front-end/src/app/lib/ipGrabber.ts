"use client";

import { useState } from "react";

export function getIp() {
  const [ip, setIp] = useState();

  fetch("https://api.ipify.org/?format=json")
    .then((res) => res.json())
    .then((data) => {
      setIp(data.ip);
    })
    .catch((error) => console.error(error));

  return ip;
}
