/**
 * @author Alex Cassady
 * Welcome to this wacko page. In summary this page uses the "fetchTeams" function to call the backend and return a promise.
 * If the function works correctly, and the backend controller works as intended then it will return to the useEffect and 
 * set the data accordingly. If not then it sets the state to false, therefore nullifying the function and returning an error.
 */

"use client"

import { useEffect, useState } from "react";
import { fetchTeams } from "@/app/scripts/fetchTeams";
import Link from 'next/link'

interface Team {
  teamId: number;
  teamName: string;
  school: string;
  type: string;
}

export default function TeamsPage() {
  const [teams, setTeams] = useState<Team[]>([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetchTeams()
      .then((data) => setTeams(data))
      .catch((err) => console.error("Error fetching teams:", err))
      .finally(() => setLoading(false));
  }, []);

  if (loading) return <h2>Loading...</h2>;

  return (
    <div>

      <Link href="../">
        <button type="button" className="flex flex-col items-center border-4 border-gray-800 p-4 bg-gray-200">
          <img src="/back.png" alt="back" className="w-28 h-28" />
          <h1 className="text-3xl">Back</h1>
        </button>
      </Link>

      <h1>Teams</h1>

      <Link href="./votes" className="flex flex-col items-center border-4 border-gray-800 p-4 bg-gray-200">
        <ul>
          {teams.map((team) => (
            <li key={team.teamId}>
              <Link href={`/team/${team.teamId}`}>
                {team.teamName}
              </Link>
            </li>
          ))}
        </ul>
      </Link>
    </div>
  );
}
