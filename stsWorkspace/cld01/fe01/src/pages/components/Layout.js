import React, { useContext } from 'react';
import { Link, NavLink, Outlet } from 'react-router';
import { LoginContext } from './LoginContext';

function Layout() {
  const { login } = useContext(LoginContext);
  return (
    <>
      <nav>
        <NavLink to={'/'}>home</NavLink>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        {}
        <NavLink to={'/intro'}>intro</NavLink>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        {''}
        <NavLink to={'/dept'}>dept</NavLink>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        {''}
        {login.result ? (
          <NavLink to={'/logout'}>logout</NavLink>
        ) : (
          <NavLink to={'/login'}>login</NavLink>
        )}
        {''}
        {login.id}
      </nav>
      <>
        <Outlet />
      </>
    </>
  );
}

export default Layout;
