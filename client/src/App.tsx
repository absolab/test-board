import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { List, Write } from 'pages';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<List />} />
        <Route path="/write" element={<Write />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
