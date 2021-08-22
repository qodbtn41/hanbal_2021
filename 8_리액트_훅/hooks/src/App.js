import React, { useState } from "react";
import "./App.css";

const content = [
  {
    tab: "Section 1",
    content: "I'm the content of the Section 1",
  },
  {
    tab: "Section 2",
    content: "I'm the content of the Section 2",
  },
];
const useInput = (initialValue, validator) => {
  const [value, setValue] = useState(initialValue);
  const onChange = (event) => {
    const {
      target: { value },
    } = event;
    let willUpdate = true;
    if (typeof validator === "function") {
      willUpdate = validator(value);
    }
    if (willUpdate) {
      setValue(value);
    }
  };
  return { value, onChange };
};

function App() {
  const maxLength = (value) => value.length < 10;
  // const special = (value) => !value.includes("@");
  const name = useInput("Mr.", maxLength);
  return (
    <div className="App">
      <h1>Hello </h1>
      <input placeholder="Name" value={name.value} onChange={name.onChange} />
      <input placeholder="Name" {...name} />
    </div>
  );
}
// 분리된 파일, 컴포넌트 내의 함수가 아니라 바깥의 함수를 쓸수가 있다.
// 무한한 확장성? 과 공통화(사전작업된 기능). 필요할때 붙여서 쓰는 느낌
// 만들어야 되는것만 만들고 나머지는 갖다 쓰는 느낌

export default App;
