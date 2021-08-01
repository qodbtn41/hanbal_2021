import React from "react";
import { HashRouter, Route } from "react-router-dom";
import About from "./routes/About";
import Home from "./routes/Home";
import Navigation from "./components/Navigation";
import Detail from "./components/Detail";

function App() {
  return (
    // BrowserRouter를 쓰면 URL에 #이 안나오지만 gh-pages에 올릴때 이것저것 설정할게 생긴다.
    <HashRouter>
      <Navigation />
      <Route path="/" exact component={Home} />
      <Route path="/introduction">
        <h1>Instroduction</h1>
      </Route>
      <Route path="/about" component={About} />
      <Route path="/movie/:id" component={Detail} />
    </HashRouter>
  );
}

export default App;
