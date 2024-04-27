import React from 'react'
import classNames from "classnames";

const Menus = [
    { title: "Home", src: "home" },
    { title: "Discover", src: "discover" },
    { title: "My Queue", src: "queue", gap: true },
    { title: "My Podcast ", src: "podcast" },
    { title: "Recents", src: "recents" },
  ];

const Sidebar = () => {
    const wrapperClasses = classNames(
        'h-screen px-4 pt-8 pb-4 bg-bkcolor flex-col justify-between border-r border-b border-bkcolor-lighter',
        'w-full lg:w-1/6');
  return (
    <div className={wrapperClasses}>
        <div className="text-xl font-bold mb-5"> 
          <img src="./logo.png" alt="Logo" className="w-16 h-16 mb-2" />
      </div> 
      <ul className="pt-2">
          {Menus.map((Menu, index) => (
            <li
              key={index}
              className={`flex rounded-md p-2 cursor-pointer hover:bg-dark text-gray-300 text-sm items-center gap-x-4 
              ${Menu.gap ? "mt-6" : "mt-2"} ${
                index === 0 && "bg-light-white"
              } `}
            >
              <img src={`./${Menu.src}.png`} className="w-5 h-5"/>
              <span >
                {Menu.title}
              </span>
            </li>
          ))}
        </ul>
    </div>
  )
}

export default Sidebar;
