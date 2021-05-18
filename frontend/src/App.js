/* eslint-disable react/jsx-no-comment-textnodes */
import { BrowserRouter as Router, Route } from 'react-router-dom';
import Search from './Search/Search';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import './Search/Search.css';
import './Footer/Footer.css';
import redsearchText from './redsearchText.svg';

function App() {
  return (
    <>
      <div className="App">
        <Router>
          <Route exact path="/">
            <img src={redsearchText} alt="Logo" style={{ height: 60, margin: 50 }} />
            <Search />
          </Route>
        </Router>
      </div>
    </>
  );
}

export default App;
