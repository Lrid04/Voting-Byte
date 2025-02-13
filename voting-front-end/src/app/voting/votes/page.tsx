/**
 * @author Alex Cassady
 * Votes page component for submitting votes for a selected team.
 * Retrieves team details from the URL parameters and allows users to rate based on different criteria.
 * Captures user input and sends a POST request to the backend to submit the vote.
 * Displays a simple form with input fields for different voting aspects and a submit button.
 * Currently, there is an issue connecting to the controller in the backend.
 */


"use client"

import { useSearchParams } from "next/navigation";
import { useState } from "react";
import Link from 'next/link';

export default function Votes() {
  const searchParams = useSearchParams();
  const teamId = searchParams.get("teamId");
  const teamName = searchParams.get("teamName");

  const [vote, setVote] = useState({
    appAppeal: 0,
    amazement: 0,
    theme: 0,
    performance: 0
  });

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setVote({ ...vote, [e.target.name]: parseInt(e.target.value) });
  };

  const handleSubmit = async () => {
    const voteData = {
      teamId: Number(teamId),
      ...vote
    };

    try {
      const response = await fetch("http://localhost:8080/votes", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(voteData)
      });

      if (!response.ok) {
        throw new Error("Failed to submit vote");
      }

      console.log("Vote submitted successfully!");
    } catch (error) {
      console.error("Error submitting vote:", error);
    }
  };

  return (
    <div className="border-8 border-gray-800 p-4 bg-gray-200 flex flex-col items-center justify-center">
      <Link href="./teams">
        <button type="button" className="flex flex-col items-center border-4 border-gray-800 p-4 bg-gray-200">
          <img src="/back.png" alt="back" className="w-28 h-28" />
          <h1 className="text-3xl">Back</h1>
        </button>
      </Link>

      <h1>Voting for: {teamName}</h1>

      <form onSubmit={(e) => { e.preventDefault(); handleSubmit(); }}>
        <label>App Appeal: 
          <input type="number" name="appAppeal" min="0" max="10" onChange={handleChange} />
        </label>
        <label>Amazement: 
          <input type="number" name="amazement" min="0" max="10" onChange={handleChange} />
        </label>
        <label>Theme: 
          <input type="number" name="theme" min="0" max="10" onChange={handleChange} />
        </label>
        <label>Performance: 
          <input type="number" name="performance" min="0" max="10" onChange={handleChange} />
        </label>
        <button type="submit">Submit Vote</button>
      </form>
    </div>
  );
}
