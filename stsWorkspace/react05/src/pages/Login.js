import React, { useContext, useEffect } from 'react';
import { UserContext } from '../service/Login';

function Login() {
  const { user, setUser } = useContext(UserContext);
  useEffect(() => {
    setUser('guest');
  }, []);

  const loginFunc = async () => {
    let result = { user: 'admin' }; //fetch 되고나면
    setUser(result.user);
  };

  return (
    <>
      <h2>Login-{user}</h2>
      <button
        onClick={(e) => {
          loginFunc();
        }}
      >
        login
      </button>
    </>
  );
}

export default Login;
