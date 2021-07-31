import { Avatar } from '@material-ui/core';
import React from 'react'
import './NoticeList.css';

function NoticeList({memimg,name}) {
    return (
        <div className='noticelist'>
            <Avatar src={memimg} className='noticelist__memimg' />

            <div  className='noticelist__name'>
               
               <p>

                <b>
                    {name}
                </b>
                님이 회원님의 게시글에 댓글을 달았습니다.

                </p>

            </div>

        </div>
    )
}

export default NoticeList
