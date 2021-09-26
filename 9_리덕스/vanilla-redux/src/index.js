import { createStore } from "redux";

const plus = document.getElementById("plus");
const minus = document.getElementById("minus");
const number = document.querySelector("span");

// reducer는 데이터를 변경하는 함수다.
// 반환하는 값이 그 데이터가 된다.
// 이 안에서만 데이터를 변경할 수 있다.
const countModifier = (state = 0, action) => {
  console.log(action);
  if (action.type === "PLUS") {
    state++;
  } else if (action.type === "MINUS") {
    state--;
  }
  return state;
};

const countStore = createStore(countModifier);

const onChange = () => {
  number.innerText = countStore.getState();
};
countStore.subscribe(onChange);

plus.addEventListener("click", () => {
  countStore.dispatch({ type: "PLUS" });
});

minus.addEventListener("click", () => {
  countStore.dispatch({ type: "MINUS" });
});
