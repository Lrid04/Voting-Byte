import { NextResponse } from "next/server";
import { cookies } from "next/headers"

export async function GET(){
    const userCookie = await cookies();
    userCookie.set("auth", "true", {maxAge: 3600, sameSite: "strict"})
    return NextResponse.json({ status: 200 })
}