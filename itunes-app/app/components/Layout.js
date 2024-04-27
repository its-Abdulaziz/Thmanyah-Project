import React from 'react'
import Sidebar from './Sidebar'
import SearchPage from './SearchPage'

const Layout = () => {
  return (
    <>
    <div className='flex flex-col lg:flex-row h-screen'>
        <Sidebar />
        <SearchPage/>
    </div>
    </>
  )
}

export default Layout