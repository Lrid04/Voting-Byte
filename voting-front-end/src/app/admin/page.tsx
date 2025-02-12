export default function homePage(){
    return(
        <div>
            <h1>Welcome</h1>
            <p>Hello! This is the Admin page for Byte Jam. Below are some instructions 
                on how to use each page
            </p>
            <h1>Teams Page</h1>
            <p>This is where you will add all of the teams that are signed up for the Byte Jam.
                You must enter the team name, what school they&apos;re from, and what division they are in.
                There are three divisions, Bits, Bytes ad IHCC. Bits and bytes are only for high school 
                teams, and IHCC is only for college teams. You can also remove individual teams, or drop 
                all of the teams, but you should onl need to do that after Byte Jam is over to put in new teams.
            </p>
            <h1>Companies Page</h1>
            <p>For the companies page you must enter the name of the company, and a pin is automatically generated. This pin
                will act as a password for company representatives when accessing the voting app.
                it might be a good idea to add the same company more than once to have a few extra pins just in case.
                Companies can only vote for IHCC College teams.
            </p>
            <h1>Coaches/Judges Page</h1>
            <p>This is similar to the teams page, but is also includes an automatically generated pin for the coaches/Judges, which will be used
                as a password to gain access to the voting. It should be noted that Bits coaches will vote for teams in the 
                Bytes division and vice versa. IHCC judges can vote for both Bits and Bytes Teams
            </p>
            <h1>Results Page</h1>
            <p>This is where the results of the event are displayed. You can filter the results by IHCC staff,
                Coaches,Company, and Student. There is a button to clear all of the results, but you will need to do that when the event is over.
            </p>
        </div>
        
    )
}
