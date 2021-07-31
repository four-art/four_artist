import React from 'react'
import './Teamchannel.css'
import TeamChannelCard from './TeamChannelCard'
import TeamChannelHeader from './TeamChannelHeader'

function Teamchannel() {
    return (
        <div className='teamchannel'>
            <TeamChannelHeader />
            <TeamChannelCard />
        </div>
    )
}

export default Teamchannel
