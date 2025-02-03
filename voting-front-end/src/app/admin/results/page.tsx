import { error } from "console";

export default function Results(){

  function deleteFn(){
    fetch("http://localhost:8080/auth/clearTables")
    .then((res) => {
      if (res.ok){
        console.log('Sucess')
      }else{
        console.log("Error: ", error); 
      }
    });
  }


    return(
      <div>
        <h1>Result</h1>
        <button onClick={deleteFn}>Clear all tables</button>
      </div>
      
    );

}