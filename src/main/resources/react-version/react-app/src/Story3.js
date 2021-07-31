import React from 'react'
import './Story3.css';

function Story3({image,title, title1}) {


    return (
        <div
         className="story3">
            <img src={image} alt="" />
            <div className="story3__div__1">{title}</div> 
            <div className="story3__div__2">{title1}</div>     
        </div>
    )
}

export default Story3
