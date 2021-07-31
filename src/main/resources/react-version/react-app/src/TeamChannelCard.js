import React from 'react'
import './TeamChannelCard.css';
import TeamChannelCardComp from './TeamChannelCardComp';

function TeamChannelCard() {
    return (
        <div className='teamchannelcard'>
            <TeamChannelCardComp 
            image="https://upload.wikimedia.org/wikipedia/commons/thumb/2/2f/Google_2015_logo.svg/368px-Google_2015_logo.svg.png"
            bookmark="https://cdn.zeplin.io/609bad0ebfc228be481a98d2/assets/06A4F136-1401-42F4-9E1B-1A046847B466.svg"
            title="K-POP 댄스필름 현대무용 팀"
            members="Members"
            memimg=""
            />
             <TeamChannelCardComp 
            image="https://cdn.pixabay.com/photo/2015/04/23/17/41/node-js-736399_960_720.png"
            bookmark="https://cdn.zeplin.io/609bad0ebfc228be481a98d2/assets/06A4F136-1401-42F4-9E1B-1A046847B466.svg"
            title="팀 채널 이름"
            members="Members"
            memimg=""
            />
        </div>
    )
}

export default TeamChannelCard
