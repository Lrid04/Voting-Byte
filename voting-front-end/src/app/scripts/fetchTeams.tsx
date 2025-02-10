/**
 * Using a localhost as a developer testing ground so it can grab the controller
 * @returns A json of the teams, if nothing is found it returns and empty array to prevent crashing on the front end.
 */

export async function fetchTeams() {
  try {
      const res = await fetch("http://localhost:8080/teams");

      if (!res.ok) {
          const errorMessage = await res.text();
          throw new Error(`Failed to fetch the teams from the backend.`);
      }

      return await res.json();
  } catch (error) {
      console.error("Error fetching teams:", error);
      return []; 
  }
}
