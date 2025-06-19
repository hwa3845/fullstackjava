import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router';
import Main from './pages/Main.js';
import Intro from './pages/intro.js';
import List from './pages/List.js';
import Add from './pages/Add.js';
import Layout from './pages/modules/Layout.js';
import Ex01 from './pages/lecture/Ex01.js';
import Ex02 from './pages/lecture/Ex02.js';
import Ex03 from './pages/lecture/Ex03.js';
import Ex05 from './pages/lecture/Ex05.js';
import Ex07 from './pages/lecture/Ex07.js';
import Ex08 from './pages/lecture/Ex08.js';
import Ex09 from './pages/lecture/Ex09.js';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route element={<Layout />}>
          <Route path='/' element={<Main />} />
          <Route path='/intro' element={<Intro />} />
          <Route path='/dept' element={<List />} />
          <Route path='/dept/add' element={<Add />} />
        </Route>
        <Route path='/lec'>
          <Route path='ex01' element={<Ex01 />} />
          <Route path='ex02' element={<Ex02 />} />
          <Route path='ex03' element={<Ex03 />} />
          <Route path='ex05' element={<Ex05 />} />
          <Route path='ex07' element={<Ex07 />} />
          <Route path='ex08' element={<Ex08 />} />
          <Route path='ex09' element={<Ex09 />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
