import React from 'react'
import './MyMyTeam.css';
import PeopleAltIcon from '@material-ui/icons/PeopleAlt';

function MyMyTeam() {
    return (
        <div className='mymyteam'>
           
            <img src="https://cdn.notefolio.net/img/af/38/af389b4d2c6399e026347a48023ef99598f0edd43275b38d7ac1d0d5f160060b_v1.jpg" alt="" className='mymyteam__img' />
           
            <div className="mymyteamflex">
                <p className='mymyteam__text'>나의 팀</p>
                <PeopleAltIcon />

            </div>
       
        </div>
    )
}

export default MyMyTeam
