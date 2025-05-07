create table 'board' (
	'num' int auto_increment,
	'subject' varchar(100) not null,
	'content' text not null,
	'id' varchar(50) not null,
	'nalja' datetime default current_timestamp,
	'ref' int not null,
	'ord' int default '0',
	'lvl' int default '0',
	primary key ('num') 
) engine=InnoDB auto_increment=1 default charset=utf8mb4 collateutf8mb4_0900_ai_ci;

-- 초기 게시글 (원글 10개)
INSERT INTO board (subject, content, id, ref) VALUES 
('제목 1', '내용 1', 'user1', 1),
('제목 2', '내용 2', 'user2', 2),
('제목 3', '내용 3', 'user3', 3),
('제목 4', '내용 4', 'user4', 4),
('제목 5', '내용 5', 'user5', 5),
('제목 6', '내용 6', 'user6', 6),
('제목 7', '내용 7', 'user7', 7),
('제목 8', '내용 8', 'user8', 8),
('제목 9', '내용 9', 'user9', 9),
('제목 10', '내용 10', 'user10', 10);

-- 답글 (각 원글에 1개씩, ord = 1, lvl = 1)
INSERT INTO board (subject, content, id, ref, ord, lvl) VALUES 
('제목 1의 답글', '답글 내용 1', 'reply1', 1, 1, 1),
('제목 2의 답글', '답글 내용 2', 'reply2', 2, 1, 1),
('제목 3의 답글', '답글 내용 3', 'reply3', 3, 1, 1),
('제목 4의 답글', '답글 내용 4', 'reply4', 4, 1, 1),
('제목 5의 답글', '답글 내용 5', 'reply5', 5, 1, 1),
('제목 6의 답글', '답글 내용 6', 'reply6', 6, 1, 1),
('제목 7의 답글', '답글 내용 7', 'reply7', 7, 1, 1),
('제목 8의 답글', '답글 내용 8', 'reply8', 8, 1, 1),
('제목 9의 답글', '답글 내용 9', 'reply9', 9, 1, 1),
('제목 10의 답글', '답글 내용 10', 'reply10', 10, 1, 1);

commit;

select * from board order by ref DESC, ord ASC;

SELECT * FROM board WHERE subject LIKE '%답글%';
SELECT * FROM board WHERE subject LIKE '%제목%';