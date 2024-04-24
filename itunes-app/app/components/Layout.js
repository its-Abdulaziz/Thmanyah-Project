import React from 'react'
import Sidebar from './Sidebar'
import SidebarItem from "./Sidebar"

import { LayoutDashboard, Home, StickyNote, Layers, Flag, Calendar, LifeBuoy, Settings } from "lucide-react";


const Layout = () => {
  return (
    <div className='h-screen flex flex-row justify-start'>
        <Sidebar />
       
        
    </div>
  )
}

export default Layout