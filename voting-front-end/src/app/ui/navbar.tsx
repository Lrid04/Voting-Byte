/**
 * @author Alex Cassady
 * A UI element made to make navigation faster on the admin page
 */

import Link from 'next/link'

export default function NavBar() {
    return (
        <nav className="flex flex-col content-center justify-center w-40 absolute left-0 top-0 bg-zinc-700 h-full">
            <ul className="space-y-10">
                <li className="p-3 flex bg-zinc-400 border border-black m-2">
                    <Link href="/admin">Home</Link>
                </li>
                <li className="p-3 flex bg-zinc-400 border border-black m-2">
                    <Link href="/admin/addCoach">Coaches</Link>
                </li>
                <li className="p-3 flex bg-zinc-400 border border-black m-2">
                    <Link href="/admin/addCompany">Companies</Link>
                </li>
                <li className="p-3 flex bg-zinc-400 border border-black m-2">
                    <Link href="/admin/addTeam">Teams</Link>
                </li>
                <li className="p-3 flex bg-zinc-400 border border-black m-2">
                    <Link href="/admin/results">Results</Link>
                </li>
            </ul>
        </nav>
    )
}