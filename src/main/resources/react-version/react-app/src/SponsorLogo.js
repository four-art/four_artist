import React from 'react'
import './SponsorLogo.css';

function SponsorLogo({image, title}) {
    return (
        <div className='sponsorLogo'>
            <img src={image} alt="" />
            <p>{title}</p>
            <div className="hidden__soobin">
                <h1>
                    손수빈 개천재
                </h1>
            </div>
        </div>
    )
}

export default SponsorLogo
