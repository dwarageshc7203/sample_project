import { useState } from 'react'

function App() {
  const [height, setHeight] = useState("5");
  const [weight, setWeight] = useState("5");
  const [bmi, setBmi] = useState(null);

  const calculateBMI = async () => {

  const response = await fetch("http://localhost:8080/bmi", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify({
      height: parseFloat(height),
      weight: parseFloat(weight)
    })
  });

  const data = await response.json();
  console.log(data);
  setBmi(data.bmi);
  };

  return (
    <div>
      <h1>BMI Calculator</h1>

      <input 
      type='number'
      placeholder='Height(meters)'
      value={height}
      onChange={(e) => setHeight(e.target.value)} />

      <input 
      type='number'
      placeholder='Weight(kilogram)'
      value={weight}
      onChange={(e) => setWeight(e.target.value)} />

      <button
      type='submit' 
      onClick={calculateBMI}>
        SUMBIT </button>

      {bmi && <h2>Your BMI: {bmi}</h2>}

    </div>

    
  )
  }

export default App
