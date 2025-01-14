"use client";
import { getIp } from "./lib/ipGrabber";

export default function Page() {
  const ip = getIp();

  return (
    <div>
      <h1>Hi im just here while i steal your IP :D</h1>
      <p>{ip}</p>
    </div>
  );
}
