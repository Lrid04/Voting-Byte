"use client";
import { useState, useEffect } from "react";
import { Team } from "../../lib/interfaces";

export default function addTeam() {
  const [teams, setTeams] = useState<Team[]>([]);

  useEffect(handleFetch, []);

  function handleFetch() {
    fetch("http://localhost:8080/auth/allTeams")
      .then((res) => res.json())
      .then((data) => {
        setTeams(data);
      })
      .catch((error) => console.error(error));
  }

  return (
    <div>
      <table>
        <thead>
          <tr>
            <th>Team Name</th>
            <th>School</th>
            <th>Division</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>Team 1</td>
            <td>Keota</td>
            <td>Bits</td>
          </tr>
          {teams.map((team) => (
            <tr key={team.teamId.toString()}>
              <td>{team.teamName}</td>
              <td>{team.school}</td>
              <td>{team.category}</td>
            </tr>
          ))}
        </tbody>
      </table>
      <form>
        <label htmlFor="TeamName">Team Name: </label>
        <br />
        <input type="string" id="TeamName" name="TeamName" />
        <br />
        <label htmlFor="school">School: </label>
        <br />
        <input type="string" id="school" name="school" />
        <br />
        <label htmlFor="division">Education Division: </label>
        <select name="divison" id="division">
          <option value="BIT">Bits</option>
          <option value="BYTE">Bytes</option>
          <option value="COLLEGE">IHCC</option>
        </select>
        <button type="submit">Add Team</button>
      </form>
    </div>
  );
}
