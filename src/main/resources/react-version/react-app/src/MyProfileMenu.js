import React from 'react'
import './MyProfileMenu.css';
import MyProfileMenuAvatar from './MyProfileMenuAvatar';

function MyProfileMenu() {
    return (
        <div className='myprofilemenu'>
            
            <MyProfileMenuAvatar 
            image=""
            />

            <p className='myprofilemenu__text'>마이 프로필</p>
        </div>
    )
}

export default MyProfileMenu
