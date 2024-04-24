"use client";  
import { useState } from 'react';
import SearchBar from './SearchBar'; 

const SearchPage = () => {
  const [searchResults, setSearchResults] = useState([]);  

  const handleSearch = async (searchValue) => {
    try {
      
      const response = await fetch(`http://localhost:7036/findResults/${encodeURIComponent(searchValue)}`);  
      const data = await response.json();  
      setSearchResults(data);  
      console.log(searchResults)
    } catch (error) {
      console.error("Error during search:", error); 
    }
  };
  return (
    <div className='w-screen'>
      <SearchBar onSearch={handleSearch} /> 
    </div>

  );
};

export default SearchPage;
