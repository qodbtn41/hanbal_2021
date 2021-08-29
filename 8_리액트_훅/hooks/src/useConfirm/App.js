import React, { useEffect, useRef, useState } from "react";
// HOOKS를 사용하지 않는다.
// https://developer.mozilla.org/ko/docs/Web/API/Event/preventDefault

const usePreventLeave = () => {
  const listener = (event) => {
    event.preventDefault();
    event.returnValue = "";
  };
  const enablePrevent = () => window.addEventListener("beforeunload", listener);
  const disablePrevent = () => window.removeEventListener("beforeunload", listener);
  return { enablePrevent, disablePrevent };
};
function App() {
  // 여기에 protect, unprotect라고 썼다가 다시 고쳤는데
  // 배열이었으면 그래도 됐는데(이름이 상관없으니까)
  // 반환값이 객체니까 이름이 맞아야 나온다.
  // 2.3 강의 10:22
  const { enablePrevent, disablePrevent } = usePreventLeave();
  return (
    <div className="App">
      <button onClick={enablePrevent}>Protect</button>
      <button onClick={disablePrevent}>Unprotect</button>
    </div>
  );
}

export default App;
