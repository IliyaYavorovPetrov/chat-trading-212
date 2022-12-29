function App() {
  fetch('http://localhost:8080/api/auth/login', {
    "headers": {
      "Content-Type": "application/json"
    },
    "method": "post"
  });

  return (
    <div className="App">
      <h1>Hello</h1>
    </div>
  );
}

export default App;
