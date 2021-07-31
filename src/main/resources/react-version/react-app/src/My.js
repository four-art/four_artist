import React from 'react'
import './My.css';
import MyMyTeam from './MyMyTeam';
import MyPartner from './MyPartner';
import MyProfileMenu from './MyProfileMenu';

function My() {
    return (
        <div className='my'>
            <div className="mymymy">
                <MyProfileMenu />


                <div className="mymy">
                    <div className="my__bookmark">
                        <img src="https://cdn.zeplin.io/609bad0ebfc228be481a98d2/assets/AA96DAE3-E7DC-4A92-A461-84A4B8174A9F.svg" alt="" className='my__bookmark__img' />
                        <p className='my__bookmark__text'>북마크</p>           
                    </div>
                    <div className="my__logout">
                        <img src="https://cdn.zeplin.io/609bad0ebfc228be481a98d2/assets/D8CDFCA4-E596-4EE2-AD63-4AAB5032A91D.svg" alt="" className='my__logout__img' />
                        <p className='my__logout__text'>로그아웃</p>           
                    
                    </div>
                </div>

            </div>
        <MyMyTeam />
        <div className="mymymy">
        <MyPartner />


                <div className="mymy">
                    <div className="my__event">
                        <p className='my__event__text'>Event</p>           
                    </div>
                    <div className="my__apply">
                        <p className='my__apply__text'>채용&공모</p>           
                    
                    </div>
                    <div className="my__contact">
                        <p className='my__contact__text'>Contact</p>           
                    
                    </div>
                </div>

            </div>
        

            
        </div>
    )
}

export default My
