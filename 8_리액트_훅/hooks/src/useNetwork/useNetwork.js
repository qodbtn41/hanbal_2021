import React, { useEffect, useRef, useState } from "react";

const useNetwork = (onChange) => {
  const [status, setStatus] = useState(navigator.onLine);

  useEffect(() => {
    const handleChange = () => {
      if (typeof onChange === "function") {
        onchange(navigator.onLine);
      }
      setStatus(navigator.onLine);
    };

    window.addEventListener("online", handleChange);
    window.addEventListener("offline", handleChange);
    return () => {
      window.removeEventListener("online", handleChange);
      window.removeaddEventListener("offline", handleChange);
    };
  }, [onChange]);
  return status;
};
function App() {
  const handleNetworkChange = (online) => {
    console.log(online ? "We just went online" : "We are offline");
  };
  const online = useNetwork(handleNetworkChange);
  return (
    <div className="App">
      <h1>{online ? "Online" : "Offline"}</h1>
    </div>
  );
}

export default App;
