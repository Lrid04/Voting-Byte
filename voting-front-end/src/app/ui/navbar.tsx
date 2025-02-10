/**
 * @author Alex Cassady
 * A UI element made to make navigation faster on the admin page
 */

import Link from 'next/link'

export default function NavBar() {
    return (
        <nav className="border-2 border-black rounded-lg p-5 w-30 fixed left-5 top-20">
            <ul>
                <li className="p-3 flex bg-gray-300 border border-black m-2">
                    <Link href="/admin/">Home</Link>
                </li>
                <li className="p-3 flex bg-gray-300 border border-black m-2">
                    <Link href="/admin/coaches">Coaches</Link>
                </li>
                <li className="p-3 flex bg-gray-300 border border-black m-2">
                    <Link href="/admin/companies">Companies</Link>
                </li>
                <li className="p-3 flex bg-gray-300 border border-black m-2">
                    <Link href="/admin/teams">Teams</Link>
                </li>
                <li className="p-3 flex bg-gray-300 border border-black m-2">
                    <Link href="/admin/results">Results</Link>
                </li>
            </ul>
        </nav>
    )
}