"use client";
import { useState, useEffect, FormEvent } from "react";
import { Team } from "../../lib/interfaces";


export default function AddTeam() {
function handleSubmit(event:FormEvent<HTMLFormElement>){
  event.preventDefault();

  const data = new FormData(event.currentTarget);
  const teamName: string = data.get('TeamName') as string;
  const school: string = data.get('school') as string;
  const division: string = data.get('division') as string; 

  const sendSchool = {
    "teamName": teamName,
    "school": school,
    "category": division
  }
  const apiUrl = 'http://localhost:8080/auth/createPin';
  const options = {
      method: 'POST',
      headers: {
      'Content-Type': 'application/json', 
      },
      body: JSON.stringify(sendSchool),
  };
  fetch(apiUrl, options)
  .then(response => {
  if (response.status != 201){
      console.log("error")
  }else{
      console.log("Success")
  }
  })
};

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
  function deleteFn(){
    fetch("http://localhost:8080/auth/clearTeams")
    .then((res) => {
      if (res.ok){
        console.log('Sucess')
      }else{
        console.log("An error happened try again "); 
      }
    });
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
      <form id="schoolForm" onSubmit={handleSubmit}>
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
          <button onClick={deleteFn}>Clear Teams</button>
    </div>
  );
}
