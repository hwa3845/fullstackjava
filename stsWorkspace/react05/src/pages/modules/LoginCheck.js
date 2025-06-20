import React from 'react';
import Login from '../Login';

function LoginCheck({ children, user }) {
  return user == 'admin' ? <>{children}</> : <Login />;
}

export default LoginCheck;
