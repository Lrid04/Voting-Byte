"use client"
import Navbar from '../ui/navbar'
 import Authorization from "../lib/authorized"
import { useEffect } from "react"
import { redirect } from "next/navigation";

export default function Layout({
    children,
  }: Readonly<{
    children: React.ReactNode;
  }>){

  useEffect(() => {
    isAuthorized();
  }, [])

  async function isAuthorized(){
    if (!(await Authorization())){
      redirect("/")
    }
  }

  return (
    <div>
      <Navbar />
      <main className="text-white ml-40">{children}</main>
    </div>
  )
}