"use client";  

import { useState } from 'react';

const SearchBar = ({ onSearch }) => {
  const [searchValue, setSearchValue] = useState("");  // State for the search value

  const handleSearch = () => {
    if (onSearch) {
      onSearch(searchValue);  // Send the search value to the parent component
    }
  };

  return (
    <div className="flex justify-between py-6 px-20">
      <input 
        type="text"
        placeholder="Search here..."
        value={searchValue}
        onChange={(e) => setSearchValue(e.target.value)}  // Update state on input change
        className=" w-full h-8 px-3 py-2 font-extralight placeholder-text-light text-white text-center bg-primary rounded-xl border-none ring-1 ring-bkcolor-lighter focus:ring-gray-500 focus:ring-1"
      />
      <button onClick={handleSearch} className="text-white bg-blue-500 px-4  rounded-xl ring-1 ring-bkcolor-lighter focus:ring-gray-500 focus:ring-1">
        Search
      </button>
    </div> 
  );
};

export default SearchBar;
