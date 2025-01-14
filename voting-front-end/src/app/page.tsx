import { getIp } from "./scripts/ipGrabber";

export default function Page() {
  const ip = getIp();

  return (
    <div className="bg-blue-800">
      <h1>Hi im just here while i steal your IP :D</h1>
      <p>{ip}</p>
    </div>
  );
}
