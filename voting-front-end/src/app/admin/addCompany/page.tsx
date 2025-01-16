export default function addCompany(){
    
    const form = document.querySelector('form')!;
    form.onsubmit = (event) =>{
        event.preventDefault();
        const data = new FormData(form);
        const entry = data.get('companyName') as string;
        const apiUrl = 'https:localhost8080/createPin';
        const options: RequestInit={
            method: 'POST',
            headers: {
            'Content-Type': 'application/json', 
            },
            body: JSON.stringify({ entry }), 
        };
        fetch(apiUrl, options)
        .then(response => {
        if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
        }
        return response.json(); 
        })
        .then(data => {
         // How do we handle the data.. 
            
        })
        .catch(error => {
        
        console.error('Error:', error); 
        });
        }
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
                <label htmlFor="attendee">Company representative: </label><br/>
                <input type="string" id="attendee" name="attendee"/><br/>
                <button type="submit">Add Company</button>
            </form>
            
        </div>
    )
}