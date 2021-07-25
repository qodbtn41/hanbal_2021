import Potato from "./Potato";
import PropTypes from "prop-types";

function Food({ name }) {
  return <h1>I Like {name}</h1>;
}

Food.propTypes = {
  name: PropTypes.string.isRequired,
  image: PropTypes.string.isRequired,
  rating: PropTypes.number.isRequired,
};
const foodILike = [
  { id: 1, name: "김치", image: "", rating: 5 },
  { id: 2, name: "삼겹살", image: "", rating: 5 },
  { id: 3, name: "두부", image: "", rating: 5 },
  { id: 4, name: "감자", image: "", rating: 5 },
];

function renderFood(dish) {
  return <Food key={dish.id} name={dish.name} picture={dish.image} />;
}

function App() {
  return (
    <div className="App">
      Hello!!! <Potato />
      {foodILike.map(renderFood)}
    </div>
  );
}

export default App;
