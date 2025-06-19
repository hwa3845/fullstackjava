import React from 'react';
import { Link, Outlet } from 'react-router';

function Layout(props) {
  console.log('layout', props);
  return (
    <>
      <nav
        className='navbar bg-primary navbar-expand-lg bg-body-tertiary'
        data-bs-theme='dark'
      >
        <div className='container-fluid'>
          <ul className='navbar-nav me-auto mb-2 mb-lg-0'>
            <li className='nav-item'>
              <Link to='/' className='nav-link'>
                home
              </Link>
            </li>
            <li className='nav-item'>
              <Link to='/intro' className='nav-link'>
                intro
              </Link>
            </li>
            <li className='nav-item'>
              <Link to='/dept' className='nav-link'>
                dept
              </Link>
            </li>
          </ul>
        </div>
      </nav>
      <div className='container'>
        <Outlet />
      </div>
    </>
  );
}

export default Layout;
