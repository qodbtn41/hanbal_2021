import React, { useEffect, useRef, useState } from "react";

const useBeforeLeave = (onBefore) => {
  if (typeof onBefore !== "function") {
    return;
  }
  const handle = (event) => {
    console.log(event);
    const { clientY } = event;
    if (clientY <= 0) {
      onBefore();
    }
  };
  // useEffect는 조건이 없으니 마운트됐을때 호출된다.
  // 반환값에 넘겨지는 함수는 언마운트될때 이벤트를 지우도록 한다.
  // 마지막에 []를 넣어서 마운트될때만 실행되고 업데이트될때는 실행되지 않도록 했다.
  useEffect(() => {
    document.addEventListener("mouseleave", handle);
    return () => document.removeEventListener("mouseleave", handle);
  }, []);
};
function App() {
  const begForLife = () => console.log("Pls don't leave");
  useBeforeLeave(begForLife);
  return (
    <div className="App">
      <h1>Hello</h1>
    </div>
  );
}

export default App;
