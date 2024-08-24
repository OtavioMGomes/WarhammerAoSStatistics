import './App.css';
import GraphScatter from './Components/graphs/GraphScatter';
import NavegationBar from './Components/navegationBar/NavegationBar';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <nav>
          <NavegationBar/>
        </nav>
        <GraphScatter/>
      </header>
    </div>
  );
  
}

export default App;
