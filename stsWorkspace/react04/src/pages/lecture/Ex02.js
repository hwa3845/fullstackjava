import React, { useState } from 'react';

function Ex02() {
  const [obj, setObj] = useState({ msg: 'abc', color: 'blue' });
  return (
    <div>
      <h1 style={{ color: obj.color }}>{obj.msg}</h1>
      <button
        onClick={(e) => {
          setObj({ ...obj, color: 'red' });
          // obj.color='green';
        }}
      >
        색변경
      </button>
      <button
        onClick={(e) => {
          setObj({ ...obj, msg: 'ABC' });
          //   console.log(obj); //msg:'abc',color:'blue'
          setObj({ ...obj, color: 'green' });
          //   console.lob(obj); //msg:'abc',color:'blue'
        }}
      >
        메시지변경
      </button>
    </div>
  );
}

export default Ex02;
