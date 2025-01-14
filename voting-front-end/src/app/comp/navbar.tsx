import Link from 'next/link'

export default function NavBar() {
    return (
        <nav className="border-2 border-black rounded-lg p-5 w-30">
            <ul>
                <li className="p-3 flex bg-gray-300 border border-black m-2">
                    <Link href="/admin">Home</Link>
                </li>
                <li className="p-3 flex bg-gray-300 border border-black m-2">
                    <Link href="/admin/addCoach">Coaches</Link>
                </li>
                <li className="p-3 flex bg-gray-300 border border-black m-2">
                    <Link href="/admin/addCompany">Companies</Link>
                </li>
                <li className="p-3 flex bg-gray-300 border border-black m-2">
                    <Link href="/admin/addTeam">Teams</Link>
                </li>
                <li className="p-3 flex bg-gray-300 border border-black m-2">
                    <Link href="/admin/results">Results</Link>
                </li>
            </ul>
        </nav>
    )
}