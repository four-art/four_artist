import React from 'react'
import './TeamChannelHeader.css';
import TeamChannelTag from './TeamChannelTag';

function TeamChannelHeader() {
    return (
        <div className='teamchannelheader'>
            <TeamChannelTag 
            title="나의 팀"
            />
            <TeamChannelTag 
            title="음악"
            />
            <TeamChannelTag 
            title="무용"
            />
            <TeamChannelTag 
            title="시각"
            />
            <TeamChannelTag 
            title="극"
            />
        </div>
    )
}

export default TeamChannelHeader
