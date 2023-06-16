import React from 'react';
import Header from './components/Headers/Header';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { List } from './pages';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<List />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
