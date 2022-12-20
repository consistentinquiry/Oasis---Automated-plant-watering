import React from 'react';
import logo from './potted-plant-icon.svg';
import './app/css/App.css';
import {connect} from "react-redux";
import AccessStateFromPropsTestComponent from "./app/scripts/components/AccessStateFromPropsTestComponent";

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
      </header>
        <body>
         <AccessStateFromPropsTestComponent />
        </body>
    </div>
  );
}

export default connect()(App);
