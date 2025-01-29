import { NextRequest, NextResponse } from "next/server";
import { cookies } from "next/headers"

export async function POST(req: NextRequest){
    const userCookie = await cookies();
    const { userUsername, userPassword} = await req.json()
    .catch(error => console.error(error))

    const admin = await fetch("http://localhost:8080/auth/allAdmins")
    .then(res => {
        if(!res.ok){
            return null
        }
        return res.json()
    })
    
    const adminUser = admin[0].username
    const adminPass = admin[0].password

    if (userUsername === adminUser && userPassword === adminPass){
        userCookie.set("auth", "true", {maxAge: 86400, sameSite: "strict"})
        return NextResponse.json({ success: true }, { status: 200 })
    } else if (userUsername != adminUser && userPassword != adminPass){
        userCookie.set("auth", "false")
        return NextResponse.json(
            {
                errors: {
                    username: "Invalid Username",
                    password: "Invalid Password"
                }
            },
            { status: 401 }
        )
    } else if (userUsername != adminUser){
        userCookie.set("auth", "false")
        return NextResponse.json(
            { errors: { username: "Invalid Username"} },
            { status: 401 }
        )
    } else if (userPassword != adminPass){
        userCookie.set("auth", "false")
        return NextResponse.json(
            { errors: { password: "Invalid Password"} },
            { status: 401 }
        )
    } else{
        userCookie.set("auth", "false")
        return NextResponse.json(
            { errors: { 
                username: "Unknown Error",
                password: "Unknown Error"
            } },
            { status: 500 }
        ) 
    }
}