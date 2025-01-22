export default function addCompany(){
    return(
        <div>
            <table>
                <thead>
                    <tr>
                        <th>Company</th>
                        <th>Pin</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Principal</td>
                        <td>pRc5c5</td>
                    </tr>
                    <tr>
                        <td>Cambridge</td>
                        <td>CA5fde</td>
                    </tr>
                </tbody>
            </table>
            <form>
                <label htmlFor="companyName">Company Name: </label><br/>
                <input type="string" id="companyName" name="companyName"/><br/>
                <button type="submit">Add Company</button>
            </form>
        </div>
    )
}