"use client";
import { PDFDownloadLink, PDFViewer } from "@react-pdf/renderer";
import PdfTable from "./pdfTable";
import { Pin, Team } from "../lib/interfaces";
import TableDoc from "./pdfTable";

export default function PdfButton(props: {
  headings: string[];
  tableContent: Pin[] | Team[];
}) {
  return (
    <div>
      <PDFDownloadLink
        document={
          <PdfTable
            headings={props.headings}
            tableContent={props.tableContent}
          />  
        }
        fileName="test.pdf"
      >
        <div className="bg-zinc-600 text-white rounded-md p-2 text-center w-fit">
          <span>Download</span>
        </div>
      </PDFDownloadLink>
    </div>
  );
}
