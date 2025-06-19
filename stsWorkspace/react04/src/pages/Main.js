import React from 'react';

function Main(props) {
  console.log('main', props);
  return (
    <>
      <div style={{ marginTop: '20px' }} className='card'>
        <div className='card-body'>환영합니다</div>
      </div>
    </>
  );
}

export default Main;
