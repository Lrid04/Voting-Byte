"use client";
import { Document, Page, PDFViewer } from "@react-pdf/renderer";
import { Table, TR, TH, TD } from "@ag-media/react-pdf-table";
import { Pin, Team } from "../lib/interfaces";

export default function TableDoc(props: {
  headings: string[];
  tableContent: Pin[] | Team[];
}) {
  return (
      <Document>
        <Page>
          <Table style={{padding: "10px"}}>
            <TH>
              {props.headings.map((heading) => (
                <TD key={heading}>{heading}</TD>
              ))}
            </TH>
            {props.tableContent.map((con: Pin | Team) => (
                <TR key={Math.random()}>
                  {"pinId" in con &&
                    (con.pinType == "COMPANY" && 
                      <>
                        <TD>{con.company}</TD>
                        <TD>{con.ownerName}</TD>
                        <TD>{con.pin}</TD>
                      </>
                     || 
                      <>
                        <TD>{con.company}</TD>
                        <TD>{con.ownerName}</TD>
                        <TD>{con.pin}</TD>
                      </>
                    ) ||
                    ("teamId" in con && 
                      <>
                        <TD>{con.teamName}</TD>
                        <TD>{con.school}</TD>
                        <TD>{con.category}</TD>
                      </>)
                     || <></>}
                </TR>
              ))}
          </Table>
        </Page>
      </Document>
  );
}
