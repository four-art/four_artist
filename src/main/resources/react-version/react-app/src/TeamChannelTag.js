import React from 'react'
import './TeamChannelTag.css';

function TeamChannelTag({title}) {
    return (
        <div className='teamchanneltag'>
            <button>
                <p>
                    {title}
                </p>
            </button>
        </div>
    )
}

export default TeamChannelTag
