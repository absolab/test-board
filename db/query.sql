SELECT A.bid, A.title, A.content, A.crtn_date, A.mdfd_date, B.name
FROM TB_BOARD A, TB_USER B
WHERE A.uid = B.uid AND A.deleted = 0;

SELECT A.bid, A.title, A.content, A.crtn_date, A.mdfd_date, B.name
FROM TB_BOARD as A
JOIN TB_USER as B
ON A.uid = B.uid
WHERE A.deleted = 0;