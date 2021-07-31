import React, { useState } from 'react'
import './CommunityFilter.css';
import CommunityFilterPost from './CommunityFilterPost';

function CommunityFilter() {

    return (
        <div className='communityfilter'>
            <img src="https://cdn.zeplin.io/609bad0ebfc228be481a98d2/assets/96EC0FB5-E07F-4A5A-A7C4-8F687016FA0A.svg" alt="" />
            <CommunityFilterPost 
            title="가입인사"
            />
            <CommunityFilterPost 
            title="구해요"
            />
            <CommunityFilterPost 
            title="함께해요"
            />
            <CommunityFilterPost 
            title="아트포럼"
            />

        </div>
    )
}

export default CommunityFilter
