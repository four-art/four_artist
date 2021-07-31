import React from 'react'
import './Home.css';
import StoryReel from './StoryReel';
import ChevronRightIcon from '@material-ui/icons/ChevronRight';
import StoryReel2 from './StoryReel2';
import StoryReel3 from './StoryReel3';
import Circlevent from './Circlevent';
import Advertise from './Advertise';
import Sponsor from './Sponsor';

function Home() {
    
    return (
        <div className='home'>
               <StoryReel />
               <div className="home__4rt">
                    <h1>4RT</h1>
                    <ChevronRightIcon />
               </div>
               
                <StoryReel2 />
                <StoryReel3 />
                <Circlevent />
                <Advertise />

                <div className="home__4rt">
                    <h1>Partner</h1>
                    <ChevronRightIcon />
               </div>
               <Sponsor />
                



        </div>
    )
}

export default Home
