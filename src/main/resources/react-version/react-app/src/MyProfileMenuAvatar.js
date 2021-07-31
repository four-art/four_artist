import { Avatar } from '@material-ui/core'
import React from 'react'
import './MyProfileMenuAvatar.css';

function MyProfileMenuAvatar({image}) {
    return (
        <div className='myprofilemenuavatar'>
            <Avatar
            src={image}
            />
        </div>
    )
}

export default MyProfileMenuAvatar
