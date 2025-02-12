import Link from 'next/link'

export default function Votes(){
    return (
        <div>
            <Link href="./teams">
                <button type="button" className="flex flex-col items-center border-4 border-gray-800 p-4 bg-gray-200">
                    <img src="/back.png" alt="back" className="w-28 h-28" />
                    <h1 className="text-3xl">Back</h1>
                </button>
            </Link>
        </div>
    )
}