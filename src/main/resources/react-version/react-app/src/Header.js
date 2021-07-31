import React from 'react'
import "./Header.css";
import Home from './Home';
import { useState } from 'react';
import Community from './Community';
import Teamchannel from './Teamchannel';
import Notice from './Notice';
import My from './My';

function Header(){

    

    const [comp, setComp] = useState();

 

    return(

        <div className="header">

            <div className="header__left">
                <img onClick={()=>setComp(Home)} className="header__logo" src="https://cdn.zeplin.io/609bad0ebfc228be481a98d2/assets/205F8293-28C8-4D1E-BA74-3D12B733A0C0.png" alt="" />
                <img className="header__search" src="https://cdn.zeplin.io/609baf49911d5b01a5433e14/assets/EB68E34B-7DA4-4EE9-BF93-3522536CD0FC.svg" alt="검색" />
            </div>
            
        
            <div className="header__center">
                <div className="header__option"
                onClick={() => setComp(Home)}
                
                >
                    
                   
                    <p>홈</p>
                </div>

                <div className="header__option1"
                onClick={() => setComp(Community)}

                >
                    <p>커뮤니티</p>
                </div>

                <div className="header__option2"
                onClick={() => setComp(Teamchannel)}

                >
                    <p>팀 채널</p>
                </div>

                <div className="header__option3"
                onClick={() => setComp(Notice)}

                >
                    <p>알림</p>
                </div>

                <div className="header__option4"
                onClick={() => setComp(My)}

                >
                    <p>MY</p>
                </div>
                <div className="header__option5"
                onClick={() => setComp(My)}

                >
                    <p>&nbsp;</p>
                </div>

            </div>
            <main children={comp} />
            
        </div>
    )
}

export default Header