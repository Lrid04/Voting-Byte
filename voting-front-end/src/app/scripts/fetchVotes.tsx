/**
 * @author Alex Cassady
 * Fetches the votes from the backend, returning an array of votes.
 * If nothing is found, returns an empty array to prevent crashing.
 */

export async function fetchVotes() {
    try {
        const res = await fetch("http://localhost:8080/votes");
  
        if (!res.ok) {
            throw new Error("Failed to fetch votes from the backend.");
        }
  
        return await res.json();
    } catch (error) {
        console.error("Error fetching votes:", error);
        return [];
    }
  }
  