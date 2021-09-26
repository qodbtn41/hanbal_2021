import { createStore } from "redux";

const plus = document.getElementById("plus");
const minus = document.getElementById("minus");
const number = document.querySelector("span");

const PLUS = "PLUS";
const MINUS = "MINUS";
// reducer는 데이터를 변경하는 함수다.
// 반환하는 값이 그 데이터가 된다.
// 이 안에서만 데이터를 변경할 수 있다.
const countModifier = (count = 0, action) => {
  switch (action.type) {
    case PLUS:
      return count + 1;
    case MINUS:
      return count - 1;
    default:
      return count;
  }
};

const countStore = createStore(countModifier);

const onChange = () => {
  number.innerText = countStore.getState();
};
countStore.subscribe(onChange);

plus.addEventListener("click", () => {
  countStore.dispatch({ type: PLUS });
});

minus.addEventListener("click", () => {
  countStore.dispatch({ type: MINUS });
});
