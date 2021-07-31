import React from 'react'
import './CommunityPostCard.css';
import {Avatar} from "@material-ui/core";

function CommunityPostCard({title,hashtag,bookmark,bigtitle,post,image,name,namehashtag,reimage,re}) {
    
    

    return (
        <div className='communitypostcard'>

            <div className="cpc__header">
                <p className='cpc__title'>{title}</p>
                <p className='cpc__hashtag'>{hashtag}</p>
                <img className="cpc__bookmark" src={bookmark} alt="" />
            </div>
            
            <div className="cpc__feed1">
                <p className='cpc__bigtitle'>{bigtitle}</p>

            </div>


            <div className="cpc__feed2">
                <p className='cpc__post'>{post}</p>

            </div>


            <div className="cpc__avatar">
                <Avatar src={image} />
                <p className='cpc__name'>{name}</p>
                <p className='cpc__namehashtag'>{namehashtag}</p>
                <img className='cpc__reimg' src={reimage} alt="" />
                <p className='cpc__re'>{re}</p>

            </div>

         
            
        </div>
    )
}

export default CommunityPostCard
