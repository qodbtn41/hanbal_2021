import React, { useEffect, useRef, useState } from "react";

function App() {
  const input = useRef();
  setTimeout(() => {
    input.current.focus();
    console.log(input.current);
  }, 5000);
  return (
    <div className="App">
      <div>Hi</div>
      <input ref={input} placeholder="la" />
    </div>
  );
}

export default App;
