export default function addCoaches(){
    <div>
        <table>
            <thead>
                <tr>
                    <th> Name</th>
                    <th>School</th>
                    <th>Division</th>
                    <th>Pin</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Angela Conrad</td>
                    <td>Keota</td>
                    <td>Bits</td>
                    <td>AN2b1b</td>
                </tr>
            </tbody>
        </table>
        <form>
                <label htmlFor="name">Name: </label><br/>
                <input type="string" id="name" name="name"/><br/>
                <label htmlFor="school">School: </label><br/>
                <input type="string" id="school" name="school"/><br/>
                <label htmlFor="division">Education Division: </label>
                <select name="divison" id="division">
                    <option value="bits">Bits</option>
                    <option value="bytes">Bytes</option>
                    <option value="ihcc">IHCC</option>
                </select>
                <button type="submit">Add Name</button>
            </form>
    </div>
}