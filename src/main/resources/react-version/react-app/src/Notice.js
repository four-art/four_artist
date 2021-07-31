import React from 'react'
import './Notice.css';
import Moment from 'react-moment'
import NoticeList from './NoticeList';

function Notice() {


    return (
        <div className='notice'>

            <div className="notice__moment">
                <Moment format="MM월 DD일"></Moment>
            </div>
            <NoticeList className='notice__noticelist'
            memimg=''
            name='이름'
            />
            <NoticeList className='notice__noticelist'
            memimg=''
            name='이름'
            />
            <NoticeList className='notice__noticelist'
            memimg=''
            name='이름'
            />

            
        </div>
    )
}

export default Notice
