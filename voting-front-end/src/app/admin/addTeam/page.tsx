export default function addTeam(){
    return(
        <div>
            <table>
                <thead>
                    <tr>
                        <th>Team Name</th>
                        <th>School</th>
                        <th>Division</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Team 1</td>
                        <td>Keota</td>
                        <td>Bits</td>
                    </tr>
                </tbody>
            </table>
            <form>
                <label htmlFor="TeamName">Team Name: </label><br/>
                <input type="string" id="TeamName" name="TeamName"/><br/>
                <label htmlFor="school">School: </label><br/>
                <input type="string" id="school" name="school"/><br/>
                <button type="submit">Add Team</button>
            </form>
        </div>
    )
}