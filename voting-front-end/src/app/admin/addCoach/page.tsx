"use client";
import { useState, useEffect, FormEvent } from "react";
import { Pin } from "../../lib/interfaces";
import PdfButton from "@/app/ui/pdfButton";

export default function AddCoaches() {
  const [coaches, setCoaches] = useState<Pin[]>();
  const headings = ["School", "Name", "Division", "Pin"]

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
      <table className="border-collapse border border-gray-800 table-auto text-center">
        <thead>
          <tr>
            <th className="bg-gray-200 px-4 py-2 border">School</th>
            <th className="bg-gray-200 px-4 py-2 border">Name</th>
            <th className="bg-gray-200 px-4 py-2 border">Division</th>
            <th className="bg-gray-200 px-4 py-2 border">Pin</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td className="bg-gray-200 px-4 py-2 border">Keota</td>
            <td className="bg-gray-200 px-4 py-2 border">Angela Conrad</td>
            <td className="bg-gray-200 px-4 py-2 border">Bits</td>
            <td className="bg-gray-200 px-4 py-2 border">AN2b1b</td>
          </tr>
          {coaches
            ?.filter((c) => c.pinType == "COACH")
            .map((coach) => (
              <tr key={coach.pinId}>
                <td className="bg-gray-200 px-4 py-2 border">{coach.company}</td>
                <td className="bg-gray-200 px-4 py-2 border">{coach.ownerName}</td>
                <td className="bg-gray-200 px-4 py-2 border">{coach.pinCategory}</td>
                <td className="bg-gray-200 px-4 py-2 border">{coach.pin}</td>
              </tr>
            ))}
        </tbody>
      </table>
      <form id="coachForm" onSubmit={handleSubmit} className="w-fit h-fit bg-gray-200 mt-10">
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
        <br />
        <button type="submit">Add Name</button>
      </form>
      <button onClick={deleteFn}>Clear Coaches</button>
      {coaches != undefined && <PdfButton headings={headings} tableContent={coaches}/>}
    </div>
  );
}
