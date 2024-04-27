"use client";  

import { useState } from 'react';

const SearchBar = ({ onSearch }) => {
  const [searchValue, setSearchValue] = useState("");  
  const handleSearch = () => {
    if (onSearch) {
      onSearch(searchValue);  
    }
  };

  return (
    <div className=" flex justify-between pt-6 pb-20 px-20 border-b border-bkcolor-lighter shadow-sm">
      <input 
        type="text"
        placeholder="Search here..."
        value={searchValue}
        onChange={(e) => setSearchValue(e.target.value)}  
        className=" w-full h-8 px-4 py-2 font-extralight placeholder-text-light text-white text-center bg-primary rounded-xl border-none ring-1 ring-bkcolor-lighter focus:ring-gray-500 focus:ring-1 mr-2"
      />
      <button onClick={handleSearch} className="text-white bg-blue-500 px-4  rounded-xl ring-1 ring-bkcolor-lighter focus:ring-gray-500 focus:ring-1">
        Search
      </button>
    </div> 

    
  );
};

export default SearchBar;
