import React, { useEffect, useRef, useState } from "react";

const useFullscreen = (callback) => {
  const element = useRef();
  const triggerFull = () => {
    if (element.current) {
      element.current.requestFullScreen();
      if (callback && typeof callback === "function") {
        callback(true);
      }
    }
  };
  const exitFull = () => {
    document.exitFullscreen();
    if (callback && typeof callback === "function") {
      callback(false);
    }
  };

  return { element, triggerFull, exitFull };
};

function App() {
  const onFullS = (isFull) => {
    console.log(isFull ? "We are full" : "We are small");
  };
  const { element, triggerFull, exitFull } = useFullscreen(onFullS);
  return (
    <div className="App" style={{ height: "1000vh" }}>
      <div ref={element}>
        <img
          alt="이미지"
          src="https://www.google.com/imgres?imgurl=http%3A%2F%2F3.bp.blogspot.com%2F-IXJPvhRaLys%2FVN28jKXSEqI%2FAAAAAAAACeo%2FJE4ohwF49HY%2Fs1600%2Fvalentines-day-2015-5081660856991744.5-hp.gif&imgrefurl=https%3A%2F%2Fkorea.googleblog.com%2F2015%2F02%2Fvalentines-day.html&tbnid=QegYhbgA35g_9M&vet=12ahUKEwjGtumrwdbyAhUND6YKHQmkBvAQMygAegUIARDNAQ..i&docid=WyYL1554Fk_ZxM&w=500&h=200&itg=1&q=%EC%9D%B4%EB%AF%B8%EC%A7%80&ved=2ahUKEwjGtumrwdbyAhUND6YKHQmkBvAQMygAegUIARDNAQ"
        ></img>
        <button onClick={triggerFull}>Fullscreen</button>
        <button onClick={exitFull}>Exit Fullscreen</button>
      </div>
    </div>
  );
}

export default App;
