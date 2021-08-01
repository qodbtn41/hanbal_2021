import React from "react";
import { Link } from "react-router-dom";
function Navigation() {
  return (
    <div>
      {/* <a href="/">Home</a>
      <a href="/about">About</a> */}
      {/* 라우터 밖에서 링크를 쓸 수 없다. */}
      <Link to="/">Home</Link>
      <Link to="/about">About</Link>
    </div>
  );
}

export default Navigation;
