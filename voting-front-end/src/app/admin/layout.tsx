"use client"
import NavBar from "../comp/navbar";
import Authorization from "../lib/authorized"
import { useEffect } from "react"
import { redirect } from "next/navigation";

export default function Layout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {

  useEffect(() => {
    isAuthorized();
  }, [])

  async function isAuthorized(){
    if (!(await Authorization())){
      redirect("/")
    }
  }

  return (
    <div className="flex flex-row">
      <NavBar />
      {children}
    </div>
  );
}
