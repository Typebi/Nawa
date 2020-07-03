--create user subpj identified by java;
--grant resource, connect to subpj;
--conn subpj/java;

drop table ATTR_IMG;
drop table REVIEW_IMG;
drop table USER_COMMENT;
drop table COMMUNITY;
drop table REVIEW;
drop table USER_FAVORITE;
drop table ATTR;
drop table STAFF;
drop table MEMBER;
drop table AREA;

drop sequence ATTR_SEQ;
drop sequence A_IMG_SEQ;
drop sequence RE_SEQ;
drop sequence RE_IMG_SEQ;
drop sequence C_SEQ;
drop sequence COMM_SEQ;
drop sequence FAV_SEQ;

purge recyclebin;
--회원
CREATE TABLE MEMBER(
   EMAIL varchar2(100) constraint MEMBER_PK primary key,
   PWD varchar2(100) NOT NULL,
   NICK_NAME varchar2(30),
   GRADE number default 0,
   RDATE DATE default SYSDATE
);
--스태프 권한을 가진 계정
CREATE TABLE STAFF( 
   EMAIL varchar2(100) constraint STAFF_PK primary key,
   PWD varchar2(30) NOT NULL,
   NICK_NAME varchar2(30) default '관리자',
   GRADE number default 1,
   RDATE date default SYSDATE
);
--지역코드
create table AREA(
   AREA_NO NUMBER constraint AREA_PK primary key,
   AREA_NAME varchar2(15)
);
--명소게시판
CREATE TABLE ATTR(
   ATTR_SEQ number constraint ATTR_SEQ_PK primary key,
   EMAIL varchar2(100) constraint ATTR_EMAIL_FK references STAFF(EMAIL),
   ATTR_NAME varchar2(150),
   ATTR_ADDR varchar2(1000),
   ATTR_INFO varchar2(2000),
   AVG_REC number default 0,
   AREA_NO number constraint AREA_NO_FK1 references AREA(AREA_NO)
);
--명소게시물에 연동된 이미지들
create table ATTR_IMG(
   A_IMG_SEQ number,
   ATTR_SEQ number constraint IMAGE_SEQ_FK references ATTR(ATTR_SEQ) on delete cascade,
   FNAME varchar2(100) constraint A_IMG_FNAME_PK primary key,
   OFNAME varchar2(100)
);
--리뷰   RATE:평점 RECOMMENT:추천
create table REVIEW(
   RE_SEQ number constraint RE_SEQ_PK PRIMARY KEY,
   ATTR_SEQ number constraint ATTR_SEQ_FK1 references ATTR(ATTR_SEQ) on delete cascade,
   EMAIL varchar2(100) constraint REVIEW_EMAIL_FK references MEMBER(EMAIL),
   REVIEW_SUBJECT varchar2(300),
   REVIEW_CONTENT varchar2(1000),
   RATE number default 1,
   RECOMMEND number default 0,
   RDATE date default SYSDATE
);
--리뷰게시물에 연동된 이미지들
create table REVIEW_IMG(
   RE_IMG_SEQ number,
   ATTR_SEQ number constraint ATTR_SEQ_FK2 references ATTR(ATTR_SEQ) on delete cascade,
   RE_SEQ number constraint RE_SEQ_FK1 references REVIEW(RE_SEQ),
   FNAME varchar2(100) constraint C_IMG_FNAME_PK primary key,
   OFNAME varchar2(100)
);
--리뷰의 댓글 
create table USER_COMMENT(
   COMM_SEQ number constraint COMM_PK primary key,
   COMM_CONTENT varchar(200),
   RDATE date default SYSDATE,
   RE_SEQ number constraint RE_SEQ_FK2 references REVIEW(RE_SEQ) on delete cascade,
   EMAIL varchar2(100) constraint COMM_FK references MEMBER(EMAIL)
);
--커뮤니티  HITS:조회수
create table COMMUNITY(
   C_SEQ number constraint C_SEQ_PK primary key,
   SUBJECT varchar2(100),
   CONTENT varchar2(1500),
   EMAIL varchar2(100) constraint COMMUNITY_EMAIL_FK references MEMBER(EMAIL),
   RDATE date default SYSDATE,
   HITS number default 0,
   FNAME varchar2(100) default null,
   OFNAME varchar2(100) default null
);
--유저 즐겨찾기
create table USER_FAVORITE(
   FAV_SEQ number constraint FAV_SEQ_PK primary key,
   EMAIL varchar2(100) constraint USER_FAVORITE_EMAIL_FK references MEMBER(EMAIL),
   ATTR_SEQ number constraint ATTR_SEQ_FK3 references ATTR(ATTR_SEQ) on delete cascade,
   AREA_NO number constraint AREA_NO_FK2 references AREA(AREA_NO)
);

create sequence ATTR_SEQ increment by 1 start with 0 minvalue 0 nocache;
create sequence RE_SEQ increment by 1 start with 0 minvalue 0 nocache;
create sequence A_IMG_SEQ increment by 1 start with 0 minvalue 0 nocache;
create sequence RE_IMG_SEQ increment by 1 start with 0 minvalue 0 nocache;
create sequence C_SEQ increment by 1 start with 0 minvalue 0 nocache;
create sequence COMM_SEQ increment by 1 start with 0 minvalue 0 nocache;
create sequence FAV_SEQ increment by 1 start with 0 minvalue 0 nocache;

insert into MEMBER values('guest', '$2a$10$nZpNqcViHQ8eAqIcgStHmuFGqTDlAUImMxvy7dteWMAz1iWa73FJS', '손님', 0, SYSDATE);
insert into MEMBER values('kbc@hanmail.net', '$2a$10$nZpNqcViHQ8eAqIcgStHmuFGqTDlAUImMxvy7dteWMAz1iWa73FJS', '공병찬', 0, SYSDATE);
insert into MEMBER values('kbr@hanmail.net','$2a$10$nZpNqcViHQ8eAqIcgStHmuFGqTDlAUImMxvy7dteWMAz1iWa73FJS', '김보라', 0, SYSDATE);
insert into MEMBER values('kst@hanmail.net','$2a$10$nZpNqcViHQ8eAqIcgStHmuFGqTDlAUImMxvy7dteWMAz1iWa73FJS', '김성태', 0, SYSDATE);
insert into MEMBER values('ksy@hanmail.net','$2a$10$nZpNqcViHQ8eAqIcgStHmuFGqTDlAUImMxvy7dteWMAz1iWa73FJS', '김세영', 0, SYSDATE);
insert into MEMBER values('ksd@hanmail.net','$2a$10$nZpNqcViHQ8eAqIcgStHmuFGqTDlAUImMxvy7dteWMAz1iWa73FJS', '김소담', 0, SYSDATE);
insert into MEMBER values('nch@hanmail.net','$2a$10$nZpNqcViHQ8eAqIcgStHmuFGqTDlAUImMxvy7dteWMAz1iWa73FJS', '남철호', 0, SYSDATE);
insert into MEMBER values('mgi@hanmail.net','$2a$10$nZpNqcViHQ8eAqIcgStHmuFGqTDlAUImMxvy7dteWMAz1iWa73FJS', '모건일', 0, SYSDATE);
insert into MEMBER values('syb@hanmail.net','$2a$10$nZpNqcViHQ8eAqIcgStHmuFGqTDlAUImMxvy7dteWMAz1iWa73FJS', '손영빈', 0, SYSDATE);
insert into MEMBER values('ssh8@hanmail.net','$2a$10$nZpNqcViHQ8eAqIcgStHmuFGqTDlAUImMxvy7dteWMAz1iWa73FJS', '송승훈8', 0, SYSDATE);
insert into MEMBER values('ssh9@hanmail.net','$2a$10$nZpNqcViHQ8eAqIcgStHmuFGqTDlAUImMxvy7dteWMAz1iWa73FJS', '송승훈9', 0, SYSDATE);
insert into MEMBER values('aje@hanmail.net','$2a$10$nZpNqcViHQ8eAqIcgStHmuFGqTDlAUImMxvy7dteWMAz1iWa73FJS', '안정은', 0, SYSDATE);
insert into MEMBER values('yb@hanmail.net','$2a$10$nZpNqcViHQ8eAqIcgStHmuFGqTDlAUImMxvy7dteWMAz1iWa73FJS', '윤 별', 0, SYSDATE);
insert into MEMBER values('lsj@hanmail.net','$2a$10$nZpNqcViHQ8eAqIcgStHmuFGqTDlAUImMxvy7dteWMAz1iWa73FJS', '임성지', 0, SYSDATE);
insert into MEMBER values('jhb@hanmail.net','$2a$10$nZpNqcViHQ8eAqIcgStHmuFGqTDlAUImMxvy7dteWMAz1iWa73FJS', '장현봉', 0, SYSDATE);
insert into MEMBER values('jsh@hanmail.net','$2a$10$nZpNqcViHQ8eAqIcgStHmuFGqTDlAUImMxvy7dteWMAz1iWa73FJS', '전세환', 0, SYSDATE);
insert into MEMBER values('jyj@hanmail.net','$2a$10$nZpNqcViHQ8eAqIcgStHmuFGqTDlAUImMxvy7dteWMAz1iWa73FJS', '조예진', 0, SYSDATE);
insert into MEMBER values('jhj@hanmail.net','$2a$10$nZpNqcViHQ8eAqIcgStHmuFGqTDlAUImMxvy7dteWMAz1iWa73FJS', '조형진', 0, SYSDATE);
insert into MEMBER values('cjh@hanmail.net','$2a$10$nZpNqcViHQ8eAqIcgStHmuFGqTDlAUImMxvy7dteWMAz1iWa73FJS', '최종현', 0, SYSDATE);
insert into MEMBER values('hny@hanmail.net','$2a$10$nZpNqcViHQ8eAqIcgStHmuFGqTDlAUImMxvy7dteWMAz1iWa73FJS', '한나영', 0, SYSDATE);
insert into MEMBER values('hdg@hanmail.net','$2a$10$nZpNqcViHQ8eAqIcgStHmuFGqTDlAUImMxvy7dteWMAz1iWa73FJS', '한동균', 0, SYSDATE);

insert into STAFF values('admin','1111', '관리자', 1, SYSDATE);

insert into AREA values(1, '강남구');
insert into AREA values(2, '강동구');
insert into AREA values(3, '강븍구');
insert into AREA values(4, '강서구');
insert into AREA values(5, '관악구');
insert into AREA values(6, '광진구');
insert into AREA values(7, '구로구');
insert into AREA values(8, '금천구');
insert into AREA values(9, '노원구');
insert into AREA values(10, '도봉구');
insert into AREA values(11, '동대문구');
insert into AREA values(12, '동작구');
insert into AREA values(13, '마포구');
insert into AREA values(14, '서대문구');
insert into AREA values(15, '서초구');
insert into AREA values(16, '성동구');
insert into AREA values(17, '성북구');
insert into AREA values(18, '송파구');
insert into AREA values(19, '양천구');
insert into AREA values(20, '영등포구');
insert into AREA values(21, '용산구');
insert into AREA values(22, '은평구');
insert into AREA values(23, '종로구');
insert into AREA values(24, '중구');
insert into AREA values(25, '중랑구');

insert into ATTR values(ATTR_SEQ.nextval, 'admin', '경복궁', '서울 종로구 사직로 161 경복궁', '광화문 - 흥례문 - 근정문 - 근정전 - 사정전 - 강녕전 - 교태전을잇는 중심 부분은 궁궐의 핵심 공간이며, 기하학적질서에 따라 대칭적으로 건축 되었습니다.  수도 서울의 중심이고 조선의 으뜸 궁궐인 경복궁에서 격조 높고 품위 있는왕실 문화의 진수를 맛보시기 바랍니다. (화요일휴무)', 0, 23);
insert into ATTR values(ATTR_SEQ.nextval, 'admin', '서대문자연사박물관', '서울특별시 서대문구 연희동 141-52', '한국 최초로 공공기관이 직접 계획하고 설립한 자연사박물관으로, 1997년 공사를 시작하여 2003년 7월 10일에 개관하였다. 설립 목적은 어린이들에게 다양한 자연을 체계적으로 체험할 수 있는 기회를 제공하여, 인간이 자연의 일부이며 자연환경과 함께 어떻게 살아가야 할지를 알려주기 위함이다. ', 0, 14);
insert into ATTR values(ATTR_SEQ.nextval, 'admin', '롯데타워','서울 송파구 올림픽로 300','롯데월드타워는 123층, 555m 높이의 세계에서 5번째로 높은 빌딩', 0, 18);
insert into ATTR values(ATTR_SEQ.nextval, 'admin', '명동', '서울 중구 명동2가','서울특별시를 상징하는 번화가이며, 한국의 금융 중심지이기도하다. 첨단 유행문화의 거리다.  탈근대 사회로 전환되고 있는 오늘날, 장소가 가지고 있는 문화와 전통을 장소의 정체성으로 인식하여 지역개발의 한 요소로서 작용하도록 하는 경향 속에서 이 지역의 전통과 역사성은 새롭게 부각되고 있다. ', 0, 24);
insert into ATTR values(ATTR_SEQ.nextval, 'admin', '동대문디지털플라자(DDP)', '서울특별시 중구 을지로 281','끊임없이 새롭고, 쉴 새 없이 움직이는 곳꿈꾸고(Dream), 만들고(Design), 누린다(Play)는 뜻을 가지고 있는 DDP(동대문 디자인 플라자)는 전시, 패션쇼, 포럼, 컨퍼런스 등 국내외 주요 행사들을 진행하고 있다. 건축물투어는 현장접수, 행사 일정, 키즈 프로그램 등은 사이트를 통해 확인하고 신청한다.', 0, 24);
insert into ATTR values(ATTR_SEQ.nextval, 'admin', '청계천', '서울 종로구 창신동','길이 10.84km, 유역면적 59.83㎢이다.북악산·인왕산·남산 등으로 둘러싸인 서울 분지의 모든 물이 여기에 모여 동쪽으로 흐르다가 왕십리 밖 살곶이다리[箭串橋] 근처에서 중랑천(中浪川)과 합쳐 서쪽으로 흐름을 바꾸어 한강으로 빠진다. 주요 다리로는 모전교·광통교·장통교·버들다리·두물다리 등이 있다.', 0, 23);

insert into ATTR_IMG values(A_IMG_SEQ.nextval, 1,'저장된이름', '원본이름');

insert into REVIEW values(RE_SEQ.nextval, 1, 'hdg@hanmail.net','어제 여자친구랑 경복궁에 다녀왔는데', '너무 이쁘네요 ^^ 경복궁 짱^^', 5, 0, SYSDATE);
insert into REVIEW values(RE_SEQ.nextval, 2, 'kbr@hanmail.net','서대문구에 이런곳이 있었네요ㅎㅎ', '근데 겨울에 히터를 안틀어줘서 3점 드립니다.', 3, 0, SYSDATE);

insert into REVIEW_IMG values(RE_IMG_SEQ.nextval, 1, 1, '저장된이름', '원본이름');

insert into USER_COMMENT values(COMM_SEQ.nextval, '1번글의 댓글내용', SYSDATE, 1, 'lsj@hanmail.net');
insert into USER_COMMENT values(COMM_SEQ.nextval, '2번글의 댓글내용', SYSDATE, 2, 'yb@hanmail.net');

insert into COMMUNITY values(C_SEQ.nextval, '제목', '내용', 'ksy@hanmail.net', SYSDATE, 0, null, null); 

insert into USER_FAVORITE values(FAV_SEQ.nextval, 'kbc@hanmail.net', 1, 23);

commit;

select NICK_NAME from MEMBER order by NICK_NAME;
select EMAIL from STAFF;
select ATTR_SEQ, ATTR_NAME from ATTR order by ATTR_SEQ desc;
select REVIEW_CONTENT from REVIEW;
select FNAME from ATTR_IMG;
select OFNAME from REVIEW_IMG;
select COMM_CONTENT from USER_COMMENT;
