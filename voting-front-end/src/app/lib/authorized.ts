"use server"
import { cookies } from "next/headers"

export default async function Authorization(){
    const userCookies = await cookies()
    if (userCookies.get("auth")?.value == "true"){
        return true
    } else {
        return false
    }
}