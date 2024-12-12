import NavBar from "./ui/navbar"
import { getIp } from "./scripts/ipGrabber";
import Footer from "./comp/footer";
import Link from 'next/link'

export default function Page() {
  const ip = getIp();

  return (
    <div className="border-8 border-gray-800 p-4 bg-gray-200 flex flex-col items-center justify-center">
      <h1 className="text-4xl text-center border-b-8 border-gray-800 p-8 m-8">
        Select your occupation
      </h1>
      <div className="grid grid-cols-2 gap-20">

        <Link href="voting/teams">
          <button type="button" className="flex flex-col items-center border-4 border-gray-800 p-4 bg-gray-200">
            <img src="business.png" alt="Business" className="w-60 h-60" />
            <h1 className="text-3xl">Business</h1>
          </button>
        </Link>

        <Link href="voting/teams">
          <button type="button" className="flex flex-col items-center border-4 border-gray-800 p-4 bg-gray-200">
            <img src="ihcc.png" alt="IHCC" className="w-60 h-60" />
            <h1 className="text-3xl">IHCC</h1>
          </button>
        </Link>

        <Link href="voting/teams">
          <button type="button" className="flex flex-col items-center border-4 border-gray-800 p-4 bg-gray-200">
            <img src="student.png" alt="Student" className="w-60 h-60" />
            <h1 className="text-3xl">Student</h1>
          </button>
        </Link>

        <Link href="voting/teams">
          <button type="button" className="flex flex-col items-center border-4 border-gray-800 p-4 bg-gray-200">
            <img src="coach.png" alt="Coach" className="w-60 h-60"/>
            <h1 className="text-3xl">Coach</h1>
          </button>
        </Link>
      </div>
      <Footer></Footer>
    </div>
  );
}
