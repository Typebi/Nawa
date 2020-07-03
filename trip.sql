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
--ȸ��
CREATE TABLE MEMBER(
   EMAIL varchar2(100) constraint MEMBER_PK primary key,
   PWD varchar2(100) NOT NULL,
   NICK_NAME varchar2(30),
   GRADE number default 0,
   RDATE DATE default SYSDATE
);
--������ ������ ���� ����
CREATE TABLE STAFF( 
   EMAIL varchar2(100) constraint STAFF_PK primary key,
   PWD varchar2(30) NOT NULL,
   NICK_NAME varchar2(30) default '������',
   GRADE number default 1,
   RDATE date default SYSDATE
);
--�����ڵ�
create table AREA(
   AREA_NO NUMBER constraint AREA_PK primary key,
   AREA_NAME varchar2(15)
);
--��ҰԽ���
CREATE TABLE ATTR(
   ATTR_SEQ number constraint ATTR_SEQ_PK primary key,
   EMAIL varchar2(100) constraint ATTR_EMAIL_FK references STAFF(EMAIL),
   ATTR_NAME varchar2(150),
   ATTR_ADDR varchar2(1000),
   ATTR_INFO varchar2(2000),
   AVG_REC number default 0,
   AREA_NO number constraint AREA_NO_FK1 references AREA(AREA_NO)
);
--��ҰԽù��� ������ �̹�����
create table ATTR_IMG(
   A_IMG_SEQ number,
   ATTR_SEQ number constraint IMAGE_SEQ_FK references ATTR(ATTR_SEQ) on delete cascade,
   FNAME varchar2(100) constraint A_IMG_FNAME_PK primary key,
   OFNAME varchar2(100)
);
--����   RATE:���� RECOMMENT:��õ
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
--����Խù��� ������ �̹�����
create table REVIEW_IMG(
   RE_IMG_SEQ number,
   ATTR_SEQ number constraint ATTR_SEQ_FK2 references ATTR(ATTR_SEQ) on delete cascade,
   RE_SEQ number constraint RE_SEQ_FK1 references REVIEW(RE_SEQ),
   FNAME varchar2(100) constraint C_IMG_FNAME_PK primary key,
   OFNAME varchar2(100)
);
--������ ��� 
create table USER_COMMENT(
   COMM_SEQ number constraint COMM_PK primary key,
   COMM_CONTENT varchar(200),
   RDATE date default SYSDATE,
   RE_SEQ number constraint RE_SEQ_FK2 references REVIEW(RE_SEQ) on delete cascade,
   EMAIL varchar2(100) constraint COMM_FK references MEMBER(EMAIL)
);
--Ŀ�´�Ƽ  HITS:��ȸ��
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
--���� ���ã��
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

insert into MEMBER values('guest', '$2a$10$nZpNqcViHQ8eAqIcgStHmuFGqTDlAUImMxvy7dteWMAz1iWa73FJS', '�մ�', 0, SYSDATE);
insert into MEMBER values('kbc@hanmail.net', '$2a$10$nZpNqcViHQ8eAqIcgStHmuFGqTDlAUImMxvy7dteWMAz1iWa73FJS', '������', 0, SYSDATE);
insert into MEMBER values('kbr@hanmail.net','$2a$10$nZpNqcViHQ8eAqIcgStHmuFGqTDlAUImMxvy7dteWMAz1iWa73FJS', '�躸��', 0, SYSDATE);
insert into MEMBER values('kst@hanmail.net','$2a$10$nZpNqcViHQ8eAqIcgStHmuFGqTDlAUImMxvy7dteWMAz1iWa73FJS', '�輺��', 0, SYSDATE);
insert into MEMBER values('ksy@hanmail.net','$2a$10$nZpNqcViHQ8eAqIcgStHmuFGqTDlAUImMxvy7dteWMAz1iWa73FJS', '�輼��', 0, SYSDATE);
insert into MEMBER values('ksd@hanmail.net','$2a$10$nZpNqcViHQ8eAqIcgStHmuFGqTDlAUImMxvy7dteWMAz1iWa73FJS', '��Ҵ�', 0, SYSDATE);
insert into MEMBER values('nch@hanmail.net','$2a$10$nZpNqcViHQ8eAqIcgStHmuFGqTDlAUImMxvy7dteWMAz1iWa73FJS', '��öȣ', 0, SYSDATE);
insert into MEMBER values('mgi@hanmail.net','$2a$10$nZpNqcViHQ8eAqIcgStHmuFGqTDlAUImMxvy7dteWMAz1iWa73FJS', '�����', 0, SYSDATE);
insert into MEMBER values('syb@hanmail.net','$2a$10$nZpNqcViHQ8eAqIcgStHmuFGqTDlAUImMxvy7dteWMAz1iWa73FJS', '�տ���', 0, SYSDATE);
insert into MEMBER values('ssh8@hanmail.net','$2a$10$nZpNqcViHQ8eAqIcgStHmuFGqTDlAUImMxvy7dteWMAz1iWa73FJS', '�۽���8', 0, SYSDATE);
insert into MEMBER values('ssh9@hanmail.net','$2a$10$nZpNqcViHQ8eAqIcgStHmuFGqTDlAUImMxvy7dteWMAz1iWa73FJS', '�۽���9', 0, SYSDATE);
insert into MEMBER values('aje@hanmail.net','$2a$10$nZpNqcViHQ8eAqIcgStHmuFGqTDlAUImMxvy7dteWMAz1iWa73FJS', '������', 0, SYSDATE);
insert into MEMBER values('yb@hanmail.net','$2a$10$nZpNqcViHQ8eAqIcgStHmuFGqTDlAUImMxvy7dteWMAz1iWa73FJS', '�� ��', 0, SYSDATE);
insert into MEMBER values('lsj@hanmail.net','$2a$10$nZpNqcViHQ8eAqIcgStHmuFGqTDlAUImMxvy7dteWMAz1iWa73FJS', '�Ӽ���', 0, SYSDATE);
insert into MEMBER values('jhb@hanmail.net','$2a$10$nZpNqcViHQ8eAqIcgStHmuFGqTDlAUImMxvy7dteWMAz1iWa73FJS', '������', 0, SYSDATE);
insert into MEMBER values('jsh@hanmail.net','$2a$10$nZpNqcViHQ8eAqIcgStHmuFGqTDlAUImMxvy7dteWMAz1iWa73FJS', '����ȯ', 0, SYSDATE);
insert into MEMBER values('jyj@hanmail.net','$2a$10$nZpNqcViHQ8eAqIcgStHmuFGqTDlAUImMxvy7dteWMAz1iWa73FJS', '������', 0, SYSDATE);
insert into MEMBER values('jhj@hanmail.net','$2a$10$nZpNqcViHQ8eAqIcgStHmuFGqTDlAUImMxvy7dteWMAz1iWa73FJS', '������', 0, SYSDATE);
insert into MEMBER values('cjh@hanmail.net','$2a$10$nZpNqcViHQ8eAqIcgStHmuFGqTDlAUImMxvy7dteWMAz1iWa73FJS', '������', 0, SYSDATE);
insert into MEMBER values('hny@hanmail.net','$2a$10$nZpNqcViHQ8eAqIcgStHmuFGqTDlAUImMxvy7dteWMAz1iWa73FJS', '�ѳ���', 0, SYSDATE);
insert into MEMBER values('hdg@hanmail.net','$2a$10$nZpNqcViHQ8eAqIcgStHmuFGqTDlAUImMxvy7dteWMAz1iWa73FJS', '�ѵ���', 0, SYSDATE);

insert into STAFF values('admin','1111', '������', 1, SYSDATE);

insert into AREA values(1, '������');
insert into AREA values(2, '������');
insert into AREA values(3, '���뱸');
insert into AREA values(4, '������');
insert into AREA values(5, '���Ǳ�');
insert into AREA values(6, '������');
insert into AREA values(7, '���α�');
insert into AREA values(8, '��õ��');
insert into AREA values(9, '�����');
insert into AREA values(10, '������');
insert into AREA values(11, '���빮��');
insert into AREA values(12, '���۱�');
insert into AREA values(13, '������');
insert into AREA values(14, '���빮��');
insert into AREA values(15, '���ʱ�');
insert into AREA values(16, '������');
insert into AREA values(17, '���ϱ�');
insert into AREA values(18, '���ı�');
insert into AREA values(19, '��õ��');
insert into AREA values(20, '��������');
insert into AREA values(21, '��걸');
insert into AREA values(22, '����');
insert into AREA values(23, '���α�');
insert into AREA values(24, '�߱�');
insert into AREA values(25, '�߶���');

insert into ATTR values(ATTR_SEQ.nextval, 'admin', '�溹��', '���� ���α� ������ 161 �溹��', '��ȭ�� - ��ʹ� - ������ - ������ - ������ - ������ - ���������մ� �߽� �κ��� �ñ��� �ٽ� �����̸�, �������������� ���� ��Ī������ ���� �Ǿ����ϴ�.  ���� ������ �߽��̰� ������ ���� �ñ��� �溹�ÿ��� ���� ���� ǰ�� �ִ¿ս� ��ȭ�� ������ �����ñ� �ٶ��ϴ�. (ȭ�����޹�)', 0, 23);
insert into ATTR values(ATTR_SEQ.nextval, 'admin', '���빮�ڿ���ڹ���', '����Ư���� ���빮�� ���� 141-52', '�ѱ� ���ʷ� ��������� ���� ��ȹ�ϰ� ������ �ڿ���ڹ�������, 1997�� ���縦 �����Ͽ� 2003�� 7�� 10�Ͽ� �����Ͽ���. ���� ������ ��̵鿡�� �پ��� �ڿ��� ü�������� ü���� �� �ִ� ��ȸ�� �����Ͽ�, �ΰ��� �ڿ��� �Ϻ��̸� �ڿ�ȯ��� �Բ� ��� ��ư��� ������ �˷��ֱ� �����̴�. ', 0, 14);
insert into ATTR values(ATTR_SEQ.nextval, 'admin', '�Ե�Ÿ��','���� ���ı� �ø��ȷ� 300','�Ե�����Ÿ���� 123��, 555m ������ ���迡�� 5��°�� ���� ����', 0, 18);
insert into ATTR values(ATTR_SEQ.nextval, 'admin', '��', '���� �߱� ��2��','����Ư���ø� ��¡�ϴ� ��ȭ���̸�, �ѱ��� ���� �߽����̱⵵�ϴ�. ÷�� ���๮ȭ�� �Ÿ���.  Ż�ٴ� ��ȸ�� ��ȯ�ǰ� �ִ� ���ó�, ��Ұ� ������ �ִ� ��ȭ�� ������ ����� ��ü������ �ν��Ͽ� ���������� �� ��ҷμ� �ۿ��ϵ��� �ϴ� ���� �ӿ��� �� ������ ����� ���缺�� ���Ӱ� �ΰ��ǰ� �ִ�. ', 0, 24);
insert into ATTR values(ATTR_SEQ.nextval, 'admin', '���빮�������ö���(DDP)', '����Ư���� �߱� ������ 281','���Ӿ��� ���Ӱ�, �� �� ���� �����̴� ���޲ٰ�(Dream), �����(Design), ������(Play)�� ���� ������ �ִ� DDP(���빮 ������ �ö���)�� ����, �мǼ�, ����, ���۷��� �� ������ �ֿ� ������ �����ϰ� �ִ�. ���๰����� ��������, ��� ����, Ű�� ���α׷� ���� ����Ʈ�� ���� Ȯ���ϰ� ��û�Ѵ�.', 0, 24);
insert into ATTR values(ATTR_SEQ.nextval, 'admin', 'û��õ', '���� ���α� â�ŵ�','���� 10.84km, �������� 59.83���̴�.�Ͼǻꡤ�οջꡤ���� ������ �ѷ����� ���� ������ ��� ���� ���⿡ �� �������� �帣�ٰ� �սʸ� �� ����̴ٸ�[�����] ��ó���� �߶�õ(������)�� ���� �������� �帧�� �ٲپ� �Ѱ����� ������. �ֿ� �ٸ��δ� �����������뱳�����뱳������ٸ����ι��ٸ� ���� �ִ�.', 0, 23);

insert into ATTR_IMG values(A_IMG_SEQ.nextval, 1,'������̸�', '�����̸�');

insert into REVIEW values(RE_SEQ.nextval, 1, 'hdg@hanmail.net','���� ����ģ���� �溹�ÿ� �ٳ�Դµ�', '�ʹ� �̻ڳ׿� ^^ �溹�� ¯^^', 5, 0, SYSDATE);
insert into REVIEW values(RE_SEQ.nextval, 2, 'kbr@hanmail.net','���빮���� �̷����� �־��׿䤾��', '�ٵ� �ܿ￡ ���͸� ��Ʋ���༭ 3�� �帳�ϴ�.', 3, 0, SYSDATE);

insert into REVIEW_IMG values(RE_IMG_SEQ.nextval, 1, 1, '������̸�', '�����̸�');

insert into USER_COMMENT values(COMM_SEQ.nextval, '1������ ��۳���', SYSDATE, 1, 'lsj@hanmail.net');
insert into USER_COMMENT values(COMM_SEQ.nextval, '2������ ��۳���', SYSDATE, 2, 'yb@hanmail.net');

insert into COMMUNITY values(C_SEQ.nextval, '����', '����', 'ksy@hanmail.net', SYSDATE, 0, null, null); 

insert into USER_FAVORITE values(FAV_SEQ.nextval, 'kbc@hanmail.net', 1, 23);

commit;

select NICK_NAME from MEMBER order by NICK_NAME;
select EMAIL from STAFF;
select ATTR_SEQ, ATTR_NAME from ATTR order by ATTR_SEQ desc;
select REVIEW_CONTENT from REVIEW;
select FNAME from ATTR_IMG;
select OFNAME from REVIEW_IMG;
select COMM_CONTENT from USER_COMMENT;
