import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router';
import Layout from './pages/modules/Layout.js';
import Home from './pages/Home.js';
import About from './pages/About.js';
import Login from './pages/Login.js';
import Register from './pages/Register.js';
import { useState } from 'react';
import { UserContext } from './service/Login.js';
import LoginCheck from './pages/modules/LoginCheck.js';

function App() {
  const [user, setUser] = useState('guest');
  return (
    <UserContext.Provider value={{ user, setUser }}>
      {/* // <UserContext.Provider value={{ setUser }}> */}
      <BrowserRouter>
        <Routes>
          <Route element={<Layout />}>
            <Route index element={<Home />} />

            <Route
              path='about'
              element={
                <LoginCheck user={user}>
                  <About />
                </LoginCheck>
              }
            />
          </Route>
          <Route path='/join' element={<Layout />}>
            <Route path='login' element={<Login />} />
            <Route path='register' element={<Register />} />
          </Route>
        </Routes>
      </BrowserRouter>
    </UserContext.Provider>
  );
}

export default App;
