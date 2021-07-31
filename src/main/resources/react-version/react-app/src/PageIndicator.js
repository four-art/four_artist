import React from 'react'
import './PageIndicator.css';

function PageIndicator() {
    return (
        <div className='pageindicator'>
            <div className="pageindicator__left">
                <button>
                    <img src="https://cdn.zeplin.io/609bad0ebfc228be481a98d2/assets/1A2F2931-A4C8-40BC-B650-F5B5359CA5AF.svg" alt="" />
                </button>
            </div>


            <div className="pageindicator__page">
                <p>1</p>
            </div>
            <div className="pageindicator__page">
            <p>2</p>

            </div>
            <div className="pageindicator__page">
            <p>3</p>

            </div>
            <div className="pageindicator__page">
            <p>4</p>

            </div>
            <div className="pageindicator__page">
            <p>5</p>

            </div>
            <div className="pageindicator__right">
                <button>
                    <img src="https://cdn.zeplin.io/609bad0ebfc228be481a98d2/assets/3A602A27-9EB7-4D76-AEE9-4CC9091CCFB2.svg" alt="" />
                </button>
            </div>
        </div>
    )
}

export default PageIndicator
