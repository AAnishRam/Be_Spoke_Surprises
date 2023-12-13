import React from 'react';
import { MDBBtn, MDBContainer } from 'mdb-react-ui-kit';
import Login from './Components/Login';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Register from './Components/Register';

function App() {
  return (
    <div>
      
    <BrowserRouter>
    <Routes>
    <Route exact path='/' Component={Login}/>
    <Route exact path='/register' Component={Register}/>
    </Routes>
    </BrowserRouter>
    </div>
  );
}

export default App;
