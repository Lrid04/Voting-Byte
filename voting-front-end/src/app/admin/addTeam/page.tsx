"use client";
import { useState, useEffect, FormEvent } from "react";
import { Team } from "../../lib/interfaces";
import PdfButton from "@/app/ui/pdfButton";


export default function AddTeam() {
const headings = ["Team Name", "School", "Division"]

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
  const apiUrl = 'http://localhost:8080/auth/createTeam';
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
      <table className="border-collapse border border-gray-800 table-auto text-center">
        <thead>
          <tr>
            <th className="bg-gray-200 px-4 py-2 border">Team Name</th>
            <th className="bg-gray-200 px-4 py-2 border">School</th>
            <th className="bg-gray-200 px-4 py-2 border">Division</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td className="bg-gray-200 px-4 py-2 border">Team 1</td>
            <td className="bg-gray-200 px-4 py-2 border">Keota</td>
            <td className="bg-gray-200 px-4 py-2 border">Bits</td>
          </tr>
          {teams.map((team) => (
            <tr key={team.teamId.toString()}>
              <td className="bg-gray-200 px-4 py-2 border">{team.teamName}</td>
              <td className="bg-gray-200 px-4 py-2 border">{team.school}</td>
              <td className="bg-gray-200 px-4 py-2 border">{team.category}</td>
            </tr>
          ))}
        </tbody>
      </table>
      <form id="schoolForm" onSubmit={handleSubmit} className="w-fit h-fit bg-gray-200 mt-10">
        <label htmlFor="TeamName">Team Name: </label>
        <br />
        <input type="string" id="TeamName" name="TeamName" />
        <br />
        <label htmlFor="school">School: </label>
        <br />
        <input type="string" id="school" name="school" />
        <br />
        <label htmlFor="division">Education Division: </label>
        <select name="division" id="division">
          <option value="BIT">Bits</option>
          <option value="BYTE">Bytes</option>
          <option value="COLLEGE">IHCC</option>
        </select>
        <br />
        <button type="submit">Add Team</button>
      </form>
      <button onClick={deleteFn}>Clear Teams</button>
      {teams != undefined && <PdfButton headings={headings} tableContent={teams}/>}
    </div>
  );
}
