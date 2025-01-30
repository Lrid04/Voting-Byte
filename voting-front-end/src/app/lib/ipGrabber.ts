"use client";

export function getIp() {
  let ip = ""

  fetch("https://api.ipify.org/?format=json")
    .then((res) => res.json())
    .then((data) => {
      ip = data.ip
    })
    .catch((error) => console.error(error));

  return ip;
}
