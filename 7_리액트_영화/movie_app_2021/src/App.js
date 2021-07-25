import Potato from "./Potato";

function Food({ name }) {
  return <h1>{name}</h1>;
}
function App() {
  return (
    <div className="App">
      Hello!!! <Potato />
      I Like <Food name="김치" />
    </div>
  );
}

export default App;
