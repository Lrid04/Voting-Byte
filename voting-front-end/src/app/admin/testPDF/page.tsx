"use client"
import { PDFDownloadLink, PDFViewer } from "@react-pdf/renderer";
import TableDoc from "@/app/ui/tableHeader";

export default function PDF() {
  return (
    <div className="min-h-lvh">
      <PDFViewer width={"100%"} height={"100%"}>
        <TableDoc />
      </PDFViewer>
      <PDFDownloadLink document={<TableDoc/>} fileName="test.pdf">
        <div>
          <span>Download</span>
        </div>
      </PDFDownloadLink>
    </div>
  );
}
