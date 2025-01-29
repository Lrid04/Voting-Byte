"use client";
import { getIp } from "./lib/ipGrabber";

export default function Page() {
  const ip = getIp();

  function GiveAdmin(){
    fetch("api/auth/test")
  }

  return (
    <div>
      <h1>Hi im just here while i steal your IP :D</h1>
      <p>{ip}</p>
      <button onClick={GiveAdmin}>Click For Admin</button>
    </div>
  );
}
