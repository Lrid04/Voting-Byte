'use client'
import dynamic from "next/dynamic";

const PDFLink = dynamic(() => import("@/app/ui/tableHeader"),{
  ssr: false
}
)

export default function PDF() {
  return (
    <div className="min-h-lvh">
      <PDFLink/>
    </div>
  );
}
