import React from 'react'
import './CAdvertisement.css';

function CAdvertisement({image}) {
    return (
        <div className='cadvertisement'>
            <img src={image} alt="" />
        </div>
    )
}

export default CAdvertisement
