"use client"
import Image from "next/image";
import { getIp } from "./lib/ipGrabber";
/**
 * @author Alex Cassady 
 * The defualt page every user should see when voting. The page functions very basically, with four differnt buttons with each occupation.
 * Each image is just a temporary placeholder until it uses copyright free svg files. This page also calls the users Internet Protocol but
 * is unused until further notice. Adjust as needed.
 */

import Footer from "./ui/footer";
import Link from 'next/link'

export default function Page() {
  const ip = getIp();

  function GiveAdmin(){
    fetch("api/auth/test")
  }

  return (
    <div className="border-8 border-gray-800 p-4 bg-gray-200 flex flex-col items-center justify-center">
      <h1 className="text-4xl text-center border-b-8 border-gray-800 p-8 m-8">
        Select your occupation
        {ip}
      </h1>
      <div className="grid grid-cols-2 gap-20">

        <Link href="voting/teams">
          <button type="button" className="flex flex-col items-center border-4 border-gray-800 p-4 bg-gray-200">
            <Image src="/business.png" alt="Business" className="w-60 h-60" width={60} height={60}/>
            <h1 className="text-3xl">Business</h1>
          </button>
        </Link>

        <Link href="voting/teams">
          <button type="button" className="flex flex-col items-center border-4 border-gray-800 p-4 bg-gray-200">
            <Image src="/ihcc.png" alt="IHCC" className="w-60 h-60" width={60} height={60}/>
            <h1 className="text-3xl">IHCC</h1>
          </button>
        </Link>

        <Link href="voting/teams">
          <button type="button" className="flex flex-col items-center border-4 border-gray-800 p-4 bg-gray-200">
            <Image src="/student.png" alt="Student" className="w-60 h-60"  width={60} height={60}/>
            <h1 className="text-3xl">Student</h1>
          </button>
        </Link>

        <Link href="voting/teams">
          <button type="button" className="flex flex-col items-center border-4 border-gray-800 p-4 bg-gray-200">
            <Image src="/coach.png" alt="Coach" className="w-60 h-60" width={60} height={60}/>
            <h1 className="text-3xl">Coach</h1>
          </button>
        </Link>
      </div>
      <Footer></Footer>
      <button onClick={GiveAdmin}>Click For Admin</button>
    </div>
  );
}
