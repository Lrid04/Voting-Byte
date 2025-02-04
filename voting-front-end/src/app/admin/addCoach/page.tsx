"use client";
import { useState, useEffect, FormEvent } from "react";
import { Pin } from "../../lib/interfaces";

export default function AddCoaches() {
  const [coaches, setCoaches] = useState<Pin[]>();

  useEffect(handleFetch, []);

  function handleFetch() {
    fetch("http://localhost:8080/auth/allPins")
      .then((res) => res.json())
      .then((data) => {
        setCoaches(data);
      })
      .catch((error) => console.error(error));
  }

  function handleSubmit(event: FormEvent<HTMLFormElement>) {
    event.preventDefault();

    const data = new FormData(event.currentTarget);
    const name: string = data.get("name") as string;
    const school: string = data.get("school") as string;
    const division: string = data.get("division") as string;
    const addCoach = {
      pinCategory: division,
      pinType: "COACH",
      company: school,
      ownerName: name,
    };
    const apiUrl = "http://localhost:8080/auth/createPin";
    const options = {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(addCoach),
    };
    fetch(apiUrl, options)
    .then((response) => {
      if (response.status != 201) {
        console.log("error");
      } else {
        console.log("Success");
      }
    });
  }

  function deleteFn() {
    fetch("http://localhost:8080/auth/clearPins")
    .then((res) => {
      if (res.ok) {
        console.log("Sucess");
      } else {
        console.log("An error happened try again ");
      }
    });
  }

  return (
    <div>
      <table>
        <thead>
          <tr>
            <th>Name</th>
            <th>School</th>
            <th>Division</th>
            <th>Pin</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>Angela Conrad</td>
            <td>Keota</td>
            <td>Bits</td>
            <td>AN2b1b</td>
          </tr>
          {coaches
            ?.filter((c) => c.pinType == "COACH")
            .map((coach) => (
              <tr key={coach.pinId}>
                <td>{coach.ownerName}</td>
                <td>{coach.company}</td>
                <td>{coach.pinCategory}</td>
                <td>{coach.pin}</td>
              </tr>
            ))}
        </tbody>
      </table>
      <form id="coachForm" onSubmit={handleSubmit}>
        <label htmlFor="name">Name: </label>
        <br />
        <input type="string" id="name" name="name" />
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
        <button type="submit">Add Name</button>
        <button onClick={deleteFn}>Clear Coaches</button>
      </form>
    </div>
  );
}
