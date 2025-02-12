"use client";
import { useState, useEffect, FormEvent } from "react";
import { Pin } from "../../lib/interfaces";
import PdfButton from "@/app/ui/pdfButton";

export default function AddCompany() {
  // You NEED to change this to a useState and update it when there is an error
  // const errorMessage = document.getElementById('errorMessage');
  const headings = ["Company", "Representative", "Pin"]

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
      <table className="border-collapse border border-gray-800 table-auto text-center">
        <thead>
          <tr>
            <th className="bg-gray-200 px-4 py-2 border">Company</th>
            <th className="bg-gray-200 px-4 py-2 border">Representative</th>
            <th className="bg-gray-200 px-4 py-2 border">Pin</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td className="bg-gray-200 px-4 py-2 border">Principal</td>
            <td className="bg-gray-200 px-4 py-2 border">John</td>
            <td className="bg-gray-200 px-4 py-2 border">pRc5c5</td>
          </tr>
          <tr>
            <td className="bg-gray-200 px-4 py-2 border">Cambridge</td>
            <td className="bg-gray-200 px-4 py-2 border">John</td>
            <td className="bg-gray-200 px-4 py-2 border">CA5fde</td>
          </tr>
          {company
            ?.filter((c) => c.pinType == "COMPANY")
            .map((company) => (
              <tr key={company.pinId}>
                <td className="bg-gray-200 px-4 py-2 border">{company.company}</td>
                <td className="bg-gray-200 px-4 py-2 border">{company.ownerName}</td>
                <td className="bg-gray-200 px-4 py-2 border">{company.pin}</td>
              </tr>
            ))}
        </tbody>
      </table>
      <form id="companyForm" onSubmit={handleSubmit} className="w-fit h-fit bg-gray-200 mt-10">
        <label htmlFor="companyName">Company Name: </label>
        <br />
        <input type="string" id="companyName" name="companyName" />
        <br />
        <label htmlFor="attendee">Company representative: </label>
        <br />
        <input type="string" id="attendee" name="attendee" />
        <br />
        <button type="submit">Add Company</button>
      </form>
      <button onClick={deleteFn}>Clear Companies</button>
      {company != undefined && <PdfButton headings={headings} tableContent={company}/>}
    </div>
  );
}
