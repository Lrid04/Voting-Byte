"use client";
import { useState, useEffect, FormEvent } from "react";
import { Pin } from "../../lib/interfaces";

export default function AddCompany() {
  // You NEED to change this to a useState and update it when there is an error
  // const errorMessage = document.getElementById('errorMessage');
  function handleSubmit(event: FormEvent<HTMLFormElement>) {
    event.preventDefault();

    const data = new FormData(event.currentTarget);
    const company: string = data.get("companyName") as string;
    const ownerName: string = data.get("attendee") as string;
    const pinType: string = "COMPANY";
    const sendCompany = {
      pinType: pinType,
      company: company,
      ownerName: ownerName,
    };
    const apiUrl = "http://localhost:8080/auth/createPin";
    const options = {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(sendCompany),
    };
    fetch(apiUrl, options).then((response) => {
      if (response.status != 201) {
        console.log("error");
      } else {
        console.log("Success");
      }
    });
  }

  const [company, setCompany] = useState<Pin[]>();

  useEffect(handleFetch, []);

  function handleFetch() {
    fetch("http://localhost:8080/auth/allPins")
      .then((res) => res.json())
      .then((data) => {
        setCompany(data);
      })
      .catch((error) => console.error(error));
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
            <th>Company</th>
            <th>Representative</th>
            <th>Pin</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>Principal</td>
            <td>pRc5c5</td>
          </tr>
          <tr>
            <td>Cambridge</td>
            <td>CA5fde</td>
          </tr>
          {company
            ?.filter((c) => c.pinType == "COMPANY")
            .map((company) => (
              <tr key={company.pinId}>
                <td>{company.company}</td>
                <td>{company.ownerName}</td>
                <td>{company.pin}</td>
              </tr>
            ))}
        </tbody>
      </table>
      <form id="companyForm" onSubmit={handleSubmit}>
        <label htmlFor="companyName">Company Name: </label>
        <br />
        <input type="string" id="companyName" name="companyName" />
        <br />
        <label htmlFor="attendee">Company representative: </label>
        <br />
        <input type="string" id="attendee" name="attendee" />
        <br />
        <button type="submit">Add Company</button>
        <button onClick={deleteFn}>Clear Companies</button>
      </form>
    </div>
  );
}
