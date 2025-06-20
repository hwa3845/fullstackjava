import { useReducer } from 'react';
import { initialTodos, reducer } from '../service/Count';

function About() {
  //   const { user } = useContext(UserContext);
  //   const [msg, setMsg] = useState();
  //   useEffect(() => {
  //     setUser((msg) => {
  //       setMsg(msg);
  //       return msg;
  //     });
  //   }, []);

  const [todos, dispatch] = useReducer(reducer, initialTodos);

  return (
    <>
      <h2>{todos}</h2>
      <button onClick={(e) => dispatch({ type: 'plus', payload: 10 })}>
        plus
      </button>
      <button onClick={(e) => dispatch({ type: 'minus', payload: 10 })}>
        minus
      </button>
    </>
  );
}

export default About;
