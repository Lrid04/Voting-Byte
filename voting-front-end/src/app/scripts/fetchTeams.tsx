export async function fetchTeams() {
    const res = await fetch("http://localhost:8080/teams"); 
    if (!res.ok) throw new Error("Failed to fetch teams");
    return res.json();
  }
  