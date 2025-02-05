"use client";
import { PDFDownloadLink } from "@react-pdf/renderer";
import { Table, TR, TH, TD } from "@ag-media/react-pdf-table";

export default async function TableDoc() {
  return (
    <div>
      <Table>
        <TH>
          
        </TH>
      </Table>
      <PDFDownloadLink document={<p>II</p>} fileName="test.pdf">
        <div>
          <span>Download</span>
        </div>
      </PDFDownloadLink>
    </div>
  );
}
