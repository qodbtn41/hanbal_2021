import React from "react";

function About(props) {
  console.log(props);
  // 모든 라우터는 기본 props가 존재한다.
  // history
  // location
  // match
  // staticContext
  return <span>About this page: </span>;
}

export default About;
