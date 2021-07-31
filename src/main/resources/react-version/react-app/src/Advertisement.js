import React from 'react'
import './Advertisement.css';

function Advertisement({image}) {
    return (
        <div className='advertisement'>
            <img src={image} alt="" />
        </div>
    )
}

export default Advertisement
