import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router';
import Home from './pages/Home';
import AppLayout from './pages/components/AppLayout';
import List from './pages/dept/List';
import Add from './pages/dept/Add';

function App() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route element={<AppLayout />}>
            <Route index element={<Home />}></Route>
          </Route>
          <Route path='dept' element={<AppLayout />}>
            <Route index element={<List />}></Route>
            <Route path='add' element={<Add />}></Route>
          </Route>
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
