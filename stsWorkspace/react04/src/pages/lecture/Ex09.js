import React, { useEffect, useState, useRef } from 'react';

function Ex09() {
  const [msg, setMsg] = useState('');
  let before = useRef('before');
  useEffect(() => {
    before.current = msg;
  }, [msg]);
  return (
    <>
      <input value={msg} onChange={(e) => setMsg(e.target.value)} />
      <div>current msg:{msg}</div>
      <div>before msg:{before.current}</div>
    </>
  );
}

export default Ex09;
