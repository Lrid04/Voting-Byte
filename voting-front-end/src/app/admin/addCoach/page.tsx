"use client";
import { useState, useEffect } from "react";
import { Pin } from "../../lib/interfaces";

export default function addCoaches() {
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

  return (
    <div>
      <table>
        <thead>
          <tr>
            <th> Name</th>
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
      <form>
        <label htmlFor="name">Name: </label>
        <br />
        <input type="string" id="name" name="name" />
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
        <button type="submit">Add Name</button>
      </form>
    </div>
  );
}
