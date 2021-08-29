import React, { useEffect, useRef, useState } from "react";

const useClick = (onClick) => {
  if (typeof onClick !== "function") {
    return;
  }
  const element = useRef();
  useEffect(() => {
    if (element.current) {
      element.current.addEventListener("click", onClick);
    }

    return () => {
      if (element.current) {
        element.current.removeEventListener("click", onClick);
      }
    };
  }, []);
  return element;
};

function App() {
  const onClick = () => {
    console.log("say hello");
  };
  const title = useClick(onClick);

  return (
    <div className="App">
      <div ref={title}>Hi</div>
    </div>
  );
}

export default App;
