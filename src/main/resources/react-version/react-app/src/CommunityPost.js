import React from 'react'
import './CommunityPost.css';
import CommunityPostCard from './CommunityPostCard';

function CommunityPost() {
    return (
        <div className='communitypost'>
            <CommunityPostCard 
            title="구해요"
            hashtag="#편곡 #작곡 #클래식"
            bookmark="https://cdn.zeplin.io/609bad0ebfc228be481a98d2/assets/F61942D5-9998-40A6-9446-CEA1243A4429.svg"
            bigtitle="K-POP 댄스필름 현대무용 팀 편곡가 구합니다"
            post="K-POP 무용 팀을 만들려고하는데, K-POP 음악을 현대무용으로 재해석, 안무를 짜고 댄스필름으로 만들어서 유튜브 활동을 해보려해요"
            name="김수희"
            namehashtag="#현대무용 #방송댄스 #안무가 #퍼포먼서"
            reimage="https://cdn.zeplin.io/609bad0ebfc228be481a98d2/assets/6411B482-FA7F-4D35-A328-90F4B211A775.svg"
            re="15"
            />
        </div>
    )
}

export default CommunityPost
