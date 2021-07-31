import { Button } from '@material-ui/core';
import React from 'react'
import './Landingpage.css';
import { auth, provider } from "./firebase";
import { useStateValue } from './StoryProvider';
import { actionTypes } from './reducer';

function Landingpage(){

  const [state,dispatch] = useStateValue();

    const signIn = () =>{
        //Sign in...
        auth
        .signInWithPopup(provider)
        .then(result => {

            dispatch({
                type: actionTypes.SET_USER,
                user: result.user,
            });



        })
        .catch((error) => alert(error.message));
    };


    return(
        <div className="Landingpage">
     <h1 className="h11">예술을 위한<br></br>
     아티스트 소셜 네트워크<br></br><br></br></h1>
        <hr className="line"></hr><br></br>
      
        <img src="img/로고 화이트@3x.png" alt="" className="Logo">
        </img>  
        
        <p className="rt">예술과 관련된 다양한 사람들을 만날 수 있는 <b>4RT</b> <br></br>
            다양한 아티스트와 소통하며 예술활동을 공유하고, 협업해보세요</p>  
            
      <Button type="submit" onClick={signIn} className="btn-social">
        <img src="img/Button-구글로그인@3x.png" alt="" className="btn-social" style={{width: "220px", marginBottom:"18px"}}></img>   
      </Button>     
      
      <Button type="submit" onClick={signIn} className="btn-social">
        <img src="img/Button-Facebook로그인@3x.png" alt="" className="btn-social" style={{width: "220px", marginBottom:"18px"}}></img>   
      </Button> 
       <Button type="submit" onClick={signIn} className="btn-social">
        <img src="img/Button-네이버로그인@3x.png" alt="" className="btn-social" style={{width: "220px", marginBottom:"18px"}}></img>   
      </Button>           
      <Button type="submit" onClick={signIn} className="btn-social">
        <img src="img/Button-카카오로그인@3x.png" alt="" className="btn-social" style={{width: "220px", marginBottom:"18px"}}></img>   
      </Button>  

        <hr className="line"></hr>
        <p className="rrt">회원가입 시 <a href='#!'>
      이용약관</a>  및 <a href='#!'>
          개인정보처리방침
      </a>에 동의하게됩니다.
  </p>         
            <img src="img/ICON_2021-05-19/ICON.png" alt="" className="globe"></img>

            <p className="underglobe">아티스트 소셜 네트워크</p>
            <p className="sotong">음악, 무용, 미술, 전통, 다원 등 다양한 분야의 예술인들과
                예술활동을 공유하며 소통해보세요</p>

            <img src="img/dancer@3x.png" alt="" className="leftimg"></img>
            <p className="leftmal">#무용 #발레 #안무가</p>
            <img src="img/첼로.png" alt="" className="rightimg"></img>
            <p className="rightmal">#클래식 #첼로 #현대음악</p>

            <img src="img/댄스.png" alt="" className="leftimg"></img>
            <p className="leftmal">#스트리트 #댄스</p>

            <img src="img/싱어송라이터.png" alt="" className="rightimg"></img>
            <p className="rightmal">#싱어송라이터 #인디</p>

            <img src="img/작곡.png" alt="" className="leftimg"></img>
            <p className="leftmal">#작곡 #편곡 #지휘 #영상작곡</p>

            <img src="img/거문고.png" alt="" className="rightimg"></img>
            <p className="rightmal">#전통예술 #국악 #거문고</p>

            <img src="img/전자음악.png" alt="" className="leftimg"></img>
            <p className="leftmal">#전자음악 #사운드디자인</p>

            <img src="img/설치.png" alt="" className="rightimg"></img>
            <p className="rightmal">#설치 #시각 #다원예술</p>

            <img src="img/미술.png" alt="" className="leftimg"></img>
            <p className="leftmal">#미술 #페인팅 #특수분장</p>

            <img src="img/패션아트.png" alt="" className="rightimg"></img>
            <p className="rightmal">#패션아트</p>

            <img src="img/공예.png" alt="" className="leftimg"></img>
            <p className="leftmal">#공예 #조각 #소품</p>

            <img src="img/영상아트.png" alt="" className="rightimg"></img>
            <p className="rightmal">#영상아트 #포토그래퍼</p>

            <img src="img/감독.png" alt="" className="leftimg"></img>
            <p className="leftmal">#감독 #연출</p>

            <img src="img/작가.png" alt="" className="rightimg"></img>
            <p className="rightmal">#작가 #스토리 #시나리오</p>

            <br></br>
            <div className="white">
                <img src="img/협업 앤 팀 빌딩.png" alt="" className="team"></img>
                <img src="img/해시태그검색_2021-05-20/해시태그검색@3x.png" alt="" className="hash"></img>
                <img src="img/키워드검색_2021-05-20/키워드검색@3x.png" alt="" className="key"></img>
                <img src="img/게시글업로드_2021-05-20/게시글업로드@3x.png" alt="" className="post"></img>
            </div>
    </div>
    
   
  );
    
}

export default Landingpage