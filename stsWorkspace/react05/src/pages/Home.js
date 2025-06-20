import React, { useContext } from 'react';
import { UserContext } from '../service/Login';
import Login from './Login';

function Sec({ children }) {
  const { user, setUser } = useContext(UserContext);
  console.log(children);
  return (
    <div>
      <hr />
      {user == 'admin' ? children : <Login />}
      <hr />
    </div>
  );
  //   if (user == 'admin') return { children };
  //   else return <Login />;
}

function Test() {
  return (
    <Sec>
      <Test></Test>
    </Sec>
  );
}

function Home() {
  return <h2>test</h2>;
}

export default Home;
