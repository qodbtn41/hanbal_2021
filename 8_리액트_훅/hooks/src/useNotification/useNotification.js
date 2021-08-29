import React, { useEffect, useRef, useState } from "react";
// HOOKS은 아니고 함수형 프로그래밍이다
//https://developer.mozilla.org/en-US/docs/Web/API/notification

const useNotification = (title, options) => {
  if (!("Notification" in window)) {
    return;
  }
  const fireNoti = () => {
    if (Notification.permission !== "granted") {
      Notification.requestPermission().then((permission) => {
        if (permission === "granted") {
          new Notification(title, options);
        } else {
          return;
        }
      });
    } else {
      new Notification(title, options);
    }
  };
  return fireNoti;
};
function App() {
  const triggerNoti = useNotification("Can I steal your kimchi?", { body: "I love kimchi. Don't you?" });

  return (
    <div className="App" style={{ height: "1000vh" }}>
      <button onClick={triggerNoti}>Hello</button>
    </div>
  );
}

export default App;
