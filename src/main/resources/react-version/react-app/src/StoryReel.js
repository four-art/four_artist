import React from 'react'
import Story from './Story';
import "./StoryReel.css";

function StoryReel() {
    return (
        <div className="storyReel">
            <Story
            image="https://images.velog.io/images/soobinhand/profile/5eab1301-6bbd-4cb2-8d1a-e0c7eaef1e29/KakaoTalk_20201006_171245012.jpg"
            title="양천문화재단"
            
            />
            <Story
            image="https://images.velog.io/images/soobinhand/profile/5eab1301-6bbd-4cb2-8d1a-e0c7eaef1e29/KakaoTalk_20201006_171245012.jpg"
            title="손수빈"
            />
            <Story
            image="https://images.velog.io/images/soobinhand/profile/5eab1301-6bbd-4cb2-8d1a-e0c7eaef1e29/KakaoTalk_20201006_171245012.jpg"
            title="손수빈"
            />
            
            
            
        </div>
    )
}

export default StoryReel
