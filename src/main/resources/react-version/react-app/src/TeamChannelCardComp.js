import { Avatar } from '@material-ui/core';
import React from 'react'
import './TeamChannelCardComp.css';
import { AvatarGroup } from '@material-ui/lab';


function TeamChannelCardComp({image,bookmark ,title, members, memimg}) {

        return (
        <div className='teamchannelcardcomp'>

            <img src={image} alt="" className="teamchannelcardcomp__bigimg" />
            <img src={bookmark} alt="" className="teamchannelcardcomp__bookmark" />
            <p className='teamchannelcardcomp__title'>{title}</p>
            <p className='teamchannelcardcomp__members'>{members}</p>
            <AvatarGroup max={15}>
                <Avatar alt="Remy Sharp" src={memimg} />
                <Avatar alt="Travis Howard" src={memimg} />
                <Avatar alt="Cindy Baker" src={memimg} />
                <Avatar alt="Agnes Walker" src={memimg} />
                <Avatar alt="Trevor Henderson" src={memimg} />
            </AvatarGroup>
        </div>
    )
}

export default TeamChannelCardComp
