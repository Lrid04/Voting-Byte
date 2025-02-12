"use client"
import dynamic from "next/dynamic";
import { useState, useEffect } from "react";
import { Pin } from "../../lib/interfaces";
// import { PDFViewer } from "@react-pdf/renderer";
// import PdfButton from "@/app/ui/pdfButton";

const PdfButton = dynamic(() => import("@/app/ui/pdfButton"),{
  ssr: false
}
)

export default function PDF() {
  const headings = ["Company","Representative","Pin"]
  const [coaches, setCoaches] = useState<Pin[]>();

  useEffect(handleFetch, [])

  function handleFetch() {
    fetch("http://localhost:8080/auth/allPins")
      .then((res) => res.json())
      .then((data: Pin[]) => {
        if(data != undefined){
          setCoaches(data);
          console.log(data)
        }
        console.log(data)
      })
      .catch((error) => console.error(error));
  }

  return (
    <div className="min-h-lvh">
      {coaches != undefined && <PdfButton headings={headings} tableContent={coaches}/>}
    </div>
  );
}
