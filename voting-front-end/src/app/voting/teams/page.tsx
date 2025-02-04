import { useEffect, useState } from "react";
import { fetchTeams } from "@/app/scripts/fetchTeams";

export default function TeamsPage() {
  const [teams, setTeams] = useState([]);
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
      <h1>Teams</h1>
      <ul>
        {teams.map((team) => (
          <li key={team.teamId}>
            {team.teamName} - {team.school} ({team.type})
          </li>
        ))}
      </ul>
    </div>
  );
}
