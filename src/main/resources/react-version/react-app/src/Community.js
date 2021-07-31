import React from 'react'
import CAdvertise from './CAdvertise';
import './Community.css';
import CommunityFilter from './CommunityFilter';
import CommunityPost from './CommunityPost';
import PageIndicator from './PageIndicator';
import PostIcon from './PostIcon';

function Community() {
   
    return (
        <div className='community'>
            <CommunityFilter />
            <CAdvertise />
            <CommunityPost />
            <CommunityPost />
            <CommunityPost />
            <PostIcon />
            <CommunityPost />
            <CommunityPost />
            <PageIndicator />

            

            

        </div>
    )
}

export default Community
